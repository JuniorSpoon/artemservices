package com.artemas.storage.controller;

import com.artemas.storage.service.StorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/storage")
@AllArgsConstructor
public class StorageController {

    private StorageService storageService;

    @PostMapping
    public void registerStorage(){
        log.info("new storage registration");
        storageService.registerStorage();
    }
}
