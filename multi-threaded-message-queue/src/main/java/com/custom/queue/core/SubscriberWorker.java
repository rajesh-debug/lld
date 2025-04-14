package com.custom.queue.core;

import com.custom.queue.model.Message;
import com.custom.queue.model.Topic;
import com.custom.queue.model.TopicSubscriber;
import lombok.SneakyThrows;

public class SubscriberWorker implements Runnable {

    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }


    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int currentOffset = topicSubscriber.getOffset().get();
                while (currentOffset >= topic.getMessageList().size()) {
                    topicSubscriber.wait();
                }
                Message message = topic.getMessageList().get(currentOffset);
                topicSubscriber.getSubscriber().consume(message);

                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                topicSubscriber.compareAndSetOffset(currentOffset, currentOffset + 1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}
