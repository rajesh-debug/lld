package com.parkinglot.services;

import com.parkinglot.services.notification.NotificationChannelFactory.ChannelType;
import com.parkinglot.services.notification.SendNotificationService;

import java.util.List;

class SendNotificationServiceTest {

    public static void main(String[] args) {
        SendNotificationService notificationService = new SendNotificationService(
                List.of(ChannelType.EMAIL, ChannelType.SMS)
        );
        notificationService.notify("user@example.com", "Slot A4 has been booked successfully!");
        // Custom channels
        notificationService.notify("device_token_xyz", "Your booking expires soon.", List.of(ChannelType.PUSH));
    }
}

