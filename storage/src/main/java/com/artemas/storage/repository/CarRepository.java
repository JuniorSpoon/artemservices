package com.artemas.storage.repository;

import com.artemas.clients.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
