package com.custom.queue.model;

import com.custom.queue.client.ISubscriber;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
    private final ISubscriber subscriber;
    private final AtomicInteger offset = new AtomicInteger(0);

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
    }

    public void compareAndSetOffset(int current, int newOffset) {
        offset.compareAndSet(current, newOffset);
    }
}
