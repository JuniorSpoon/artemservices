package com.artemas.storage.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(
        basePackages = {
                "com.artemas.clients",
                "com.artemas.storage"
        }
)
public class StorageConfig {
}
