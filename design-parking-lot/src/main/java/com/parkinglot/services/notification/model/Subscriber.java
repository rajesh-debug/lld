package com.parkinglot.services.notification.model;

import com.parkinglot.services.notification.interfaces.NotificationChannel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Subscriber {
    private String userId;
    private String contactInfo;
    private NotificationChannel preferredChannel;
    // Constructors, getters, and setters
}
