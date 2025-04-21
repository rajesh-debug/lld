package com.parkinglot.services.notification.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class NotificationEvent {
    private String eventType;
    private String message;
    private Map<String, String> metadata;
}
