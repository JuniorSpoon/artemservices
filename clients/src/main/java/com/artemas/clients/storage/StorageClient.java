package com.artemas.clients.storage;

import com.artemas.clients.car.http.CarRegistrationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(
        name = "storage",
        url = "${clients.storage.url}"
)
public interface StorageClient {

    @PostMapping("api/v1/storage/cars")
    void registerCar(@RequestBody CarRegistrationRequest carRegistrationRequest);

}
