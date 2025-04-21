package com.parkinglot.services.notification;

import com.parkinglot.services.notification.model.NotificationEvent;
import com.parkinglot.services.notification.model.Subscriber;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationService {

    private final Map<String, Subscriber> subscribers = new ConcurrentHashMap<>();

    public void registerSubscriber(Subscriber subscriber) {
        subscribers.put(subscriber.getUserId(), subscriber);
    }

    public void notifySubscribers(NotificationEvent event) {
        for (Subscriber subscriber : subscribers.values()) {
            if (shouldNotify(subscriber, event)) {
                subscriber.getPreferredChannel().sendNotification(subscriber.getContactInfo(), event.getMessage());
            }
        }
    }

    private boolean shouldNotify(Subscriber subscriber, NotificationEvent event) {
        // Implement logic to determine if the subscriber should be notified based on event type and preferences
        return true;
    }
}
