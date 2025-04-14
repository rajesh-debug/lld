package com.custom.queue.client;

import com.custom.queue.model.Message;

public interface ISubscriber {

    String getSubscriberId();

    void consume(Message message) throws InterruptedException;
}
