package com.custom.queue.core;

import com.custom.queue.client.IQueue;
import com.custom.queue.client.ISubscriber;
import com.custom.queue.model.Message;
import com.custom.queue.model.Topic;
import com.custom.queue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue implements IQueue {

    private final Map<String, TopicHandler> topicHandlers = new HashMap<>(10);

    @Override
    public Topic createTopic(String topicName) {
        Topic topic = new Topic(UUID.randomUUID().toString(), topicName);
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlers.put(topic.getTopicId(), topicHandler);
        System.out.println("Topic created - " + topic.getTopicName());
        return topic;
    }

    @Override
    public void subscribe(ISubscriber subscriber, Topic topic) {
        topic.addTopicSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getSubscriberId() + " subscriber subscribed topic " + topic.getTopicName());
    }

    @Override
    public void publish(Topic topic, Message message) {
        topic.addMessage(message);
        System.out.println(message.getMessage() + " published to topic " + topic.getTopicName());
        new Thread(() -> topicHandlers.get(topic.getTopicId()).publish()).start();
    }
}
