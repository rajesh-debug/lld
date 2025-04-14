package com.custom.queue.client;

import com.custom.queue.model.Message;
import com.custom.queue.model.Topic;

public interface IQueue {

    Topic createTopic(String topicName);

    void subscribe(ISubscriber subscriber, Topic topic);

    void publish(Topic topic, Message message);

}
