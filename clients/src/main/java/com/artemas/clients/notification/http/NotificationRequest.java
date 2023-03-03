package com.artemas.clients.notification.http;

import java.util.UUID;

public record NotificationRequest(
        UUID vin,
        String model,
        String make,
        String message
) {
}
