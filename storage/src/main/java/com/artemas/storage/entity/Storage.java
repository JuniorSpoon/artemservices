package com.artemas.storage.entity;

import com.artemas.clients.car.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Storage {

    @Id
    @SequenceGenerator(
            name = "storage_id_sequence",
            sequenceName = "storage_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "storage_id_sequence"
    )
    private Integer id;

    @OneToMany
    @JoinTable(
            name = "storage_car",
            joinColumns = @JoinColumn(name = "storage_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars = new ArrayList<>();
}
