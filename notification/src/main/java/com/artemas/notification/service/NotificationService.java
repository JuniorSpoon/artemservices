package com.artemas.notification.service;

import com.artemas.clients.notification.http.NotificationRequest;
import com.artemas.notification.entity.Notification;
import com.artemas.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest request){
        Notification notification = Notification.builder()
                .vin(request.vin())
                .make(request.make())
                .model(request.model())
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .sender("Artem")
                .build();
        notificationRepository.save(notification);
    }
}
