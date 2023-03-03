package com.artemas.storage.service;

import com.artemas.amqp.RabbitMQMessageProducer;
import com.artemas.clients.car.http.CarRegistrationRequest;
import com.artemas.clients.car.entity.Car;
import com.artemas.clients.notification.NotificationClient;
import com.artemas.clients.notification.http.NotificationRequest;
import com.artemas.storage.entity.Storage;
import com.artemas.storage.repository.CarRepository;
import com.artemas.storage.repository.StorageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;
    private StorageRepository storageRepository;
    private RabbitMQMessageProducer rabbitMQMessageProducer;

    @Transactional
    public void registerCar(CarRegistrationRequest request){
        Storage storage = storageRepository.getById(1);

        Car car = Car.builder()
                .vin(request.vin())
                .carDescription(request.carDescription())
                .price(request.price())
                .build();

        carRepository.saveAndFlush(car);
        storageRepository.modifyingQueryInsertStorageCar(storage.getId(),car.getId());

        NotificationRequest notificationRequest =
                new NotificationRequest(
                        car.getVin(),
                        car.getCarDescription().getModel(),
                        car.getCarDescription().getMake(),
                        String.format("Car with vin %s has been registered", car.getVin())
                );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");
    }
}
