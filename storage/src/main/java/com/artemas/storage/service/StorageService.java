package com.artemas.storage.service;

import com.artemas.storage.entity.Storage;
import com.artemas.storage.repository.StorageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StorageService {

    private StorageRepository storageRepository;

    public void registerStorage(){
        Storage storage = new Storage();
        storageRepository.save(storage);
    }
}
