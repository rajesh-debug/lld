package com.parkinglot.services.notification;

import com.parkinglot.services.notification.interfaces.EmailNotificationChannel;
import com.parkinglot.services.notification.interfaces.NotificationChannel;
import com.parkinglot.services.notification.interfaces.PushNotificationChannel;
import com.parkinglot.services.notification.interfaces.SMSNotificationChannel;

public class NotificationChannelFactory {

    public static NotificationChannel getChannel(ChannelType type) {
        return switch (type) {
            case EMAIL -> new EmailNotificationChannel();
            case SMS -> new SMSNotificationChannel();
            case PUSH -> new PushNotificationChannel();
        };
    }

    public enum ChannelType {
        EMAIL,
        SMS,
        PUSH
    }
}
