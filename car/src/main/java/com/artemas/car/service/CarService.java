package com.artemas.car.service;

import com.artemas.car.repository.CarRepository;
import com.artemas.clients.car.entity.Car;
import com.artemas.clients.car.http.CarRegistrationRequest;
import com.artemas.clients.storage.StorageClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final RestTemplate restTemplate;
    private final StorageClient storageClient;

    public void registerCar(CarRegistrationRequest request) {
        Car car = Car.builder()
                .carDescription(request.carDescription())
                .vin(request.vin())
                .price(request.price())
                .build();
        carRepository.save(car);
        storageClient.registerCar(request);

    }
}
