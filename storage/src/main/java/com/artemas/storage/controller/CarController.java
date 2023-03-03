package com.artemas.storage.controller;

import com.artemas.clients.car.http.CarRegistrationRequest;
import com.artemas.storage.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/storage/cars")
@AllArgsConstructor
public class CarController {

    private CarService carService;

    @PostMapping
    public void registerCar(@RequestBody CarRegistrationRequest carRegistrationRequest) {
        log.info("new car registration {}", carRegistrationRequest);
        carService.registerCar(carRegistrationRequest);
        //CarRegistrationResponse carRegistrationResponse = new CarRegistrationResponse(true);
        //return new ResponseEntity<>(carRegistrationResponse, HttpStatus.CREATED);
    }
}
