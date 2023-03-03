package com.artemas.clients.car.http;

import com.artemas.clients.car.entity.CarDescription;

import java.util.UUID;

public record CarRegistrationRequest(
        CarDescription carDescription,
        UUID vin,
        Double price) {
}
