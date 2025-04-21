package com.parkinglot.services.notification.interfaces;

public class PushNotificationChannel implements NotificationChannel {

    @Override
    public void sendNotification(String recipient, String message) {
        // Simulate sending a push notification (can be integrated with Firebase, OneSignal, etc.)
        System.out.printf("[Push Notification] To: %s | Message: %s%n", recipient, message);
    }
}
