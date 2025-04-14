package com.custom.queue.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {

    private final String topicId;
    private final String topicName;
    private final List<TopicSubscriber> topicSubscribers = new ArrayList<>();
    private final List<Message> messageList = new ArrayList<>();


    // these two information will be passed creating the Topic, rest is dynamic one
    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public List<TopicSubscriber> getTopicSubscribers() {
        return new ArrayList<>(topicSubscribers); // do not pass the param tnat can be modified from outside.
    }

    public List<Message> getMessageList() {
        return new ArrayList<>(messageList);
    }

    public synchronized void addTopicSubscriber(TopicSubscriber topicSubscriber) {
        this.topicSubscribers.add(topicSubscriber);
    }

    public synchronized void addMessage(Message message) {
        this.messageList.add(message);
    }
}
