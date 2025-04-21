package com.parkinglot.services.notification.interfaces;

public interface NotificationChannel {
    void sendNotification(String recipient, String message);
}
