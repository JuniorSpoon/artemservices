package com.artemas.car.controller;

import com.artemas.car.service.CarService;
import com.artemas.clients.car.http.CarRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/cars")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    @PostMapping
    public void registerCar(@RequestBody CarRegistrationRequest carRegistrationRequest){
        log.info("new car registration {}", carRegistrationRequest);
        carService.registerCar(carRegistrationRequest);
    }
}
