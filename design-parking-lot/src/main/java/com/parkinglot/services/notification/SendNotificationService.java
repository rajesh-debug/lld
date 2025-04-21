package com.parkinglot.services.notification;

import com.parkinglot.services.notification.interfaces.NotificationChannel;

import java.util.List;

public class SendNotificationService {

    private final List<NotificationChannelFactory.ChannelType> defaultChannels;

    public SendNotificationService(List<NotificationChannelFactory.ChannelType> defaultChannels) {
        this.defaultChannels = defaultChannels;
    }

    public void notify(String recipient, String message) {
        for (NotificationChannelFactory.ChannelType channelType : defaultChannels) {
            NotificationChannel channel = NotificationChannelFactory.getChannel(channelType);
            channel.sendNotification(recipient, message);
        }
    }

    // Optionally send via specific channels
    public void notify(String recipient, String message, List<NotificationChannelFactory.ChannelType> channels) {
        for (NotificationChannelFactory.ChannelType channelType : channels) {
            NotificationChannel channel = NotificationChannelFactory.getChannel(channelType);
            channel.sendNotification(recipient, message);
        }
    }
}
