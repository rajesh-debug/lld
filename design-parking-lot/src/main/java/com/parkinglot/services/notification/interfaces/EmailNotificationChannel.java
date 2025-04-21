package com.parkinglot.services.notification.interfaces;

public class EmailNotificationChannel implements NotificationChannel {

    @Override
    public void sendNotification(String recipient, String message) {
        // Simulate sending an email (replace with actual email service integration like SendGrid/Mailgun)
        System.out.printf("[Email] To: %s | Message: %s%n", recipient, message);
    }
}
