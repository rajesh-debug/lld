package com.custom.queue.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Message {
    private final String message;
    private final Date date;

    public Message(String message) {
        this.message = message;
        this.date = new Date();
    }
}
