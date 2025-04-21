package com.parkinglot.services.notification.interfaces;

public class SMSNotificationChannel implements NotificationChannel {

    @Override
    public void sendNotification(String recipient, String message) {
        // Simulate sending an SMS (replace with real SMS provider like Twilio)
        System.out.printf("[SMS] To: %s | Message: %s%n", recipient, message);
    }
}
