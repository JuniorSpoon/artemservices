package com.artemas.storage.repository;

import com.artemas.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StorageRepository extends JpaRepository<Storage, Integer> {

    @Modifying
    @Query(value = "INSERT INTO storage_car (storage_id, car_id) VALUES (:storageId, :carId)", nativeQuery = true)
    void modifyingQueryInsertStorageCar(@Param("storageId") Integer storageId, @Param("carId") Integer carId);
}
