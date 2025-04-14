package com.custom.queue;

import com.custom.queue.client.ISubscriber;
import com.custom.queue.model.Message;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Subscriber implements ISubscriber {

    private final String subscriberId;
    private final int sleepDuration;

    public Subscriber(@NonNull String subscriberId, int sleepDuration) {
        this.subscriberId = subscriberId;
        this.sleepDuration = sleepDuration;

    }

    @Override
    public void consume(@NonNull Message message) throws InterruptedException {
        System.out.println("[Subscriber-started] " + subscriberId + " for Message " + message.getMessage());
        Thread.sleep(sleepDuration);
        System.out.println("[Subscriber-ended] " + subscriberId + " for Message " + message.getMessage());
    }

    @Override
    public String getSubscriberId() {
        return this.subscriberId;
    }
}
