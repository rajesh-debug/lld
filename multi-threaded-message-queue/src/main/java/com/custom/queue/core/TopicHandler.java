package com.custom.queue.core;


import com.custom.queue.model.Topic;
import com.custom.queue.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {

    private final Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkers = new HashMap<>();

    public TopicHandler(Topic topic) {
        this.topic = topic;
    }

    public void publish() {
        for (TopicSubscriber subscriberWorker : topic.getTopicSubscribers()) {
            startSubscriber(subscriberWorker);
        }
    }

    private void startSubscriber(TopicSubscriber topicSubscriber) {
        String subscriberId = topicSubscriber.getSubscriber().getSubscriberId();
        if(!subscriberWorkers.containsKey(subscriberId)) {
            SubscriberWorker sb = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, sb);
            new Thread(sb).start();
        }

        SubscriberWorker sb = subscriberWorkers.get(subscriberId);
        sb.wakeUpIfNeeded();
    }
}
