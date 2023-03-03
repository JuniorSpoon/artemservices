package com.artemas.clients.car.entity;

import com.artemas.clients.car.enums.CarType;
import com.artemas.clients.car.enums.Gear;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDescription {

    private String make;
    private String model;
    @Enumerated(EnumType.STRING)
    private CarType carType;
    private String color;
    @Enumerated(EnumType.STRING)
    private Gear gear;
}
