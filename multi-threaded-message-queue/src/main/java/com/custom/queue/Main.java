package com.custom.queue;

import com.custom.queue.client.IQueue;
import com.custom.queue.core.Queue;
import com.custom.queue.model.Message;
import com.custom.queue.model.Topic;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        IQueue queue = new Queue();

        Topic topic1 = queue.createTopic("topic-1");
        Topic topic2 = queue.createTopic("topic-2");
        Topic topic3 = queue.createTopic("topic-3");
        Topic topic4 = queue.createTopic("topic-4");

        Subscriber subscriber1 = new Subscriber("subscriber-1", 1000);
        Subscriber subscriber2 = new Subscriber("subscriber-2", 1000);
        Subscriber subscriber3 = new Subscriber("subscriber-3", 1000);
        Subscriber subscriber4 = new Subscriber("subscriber-4", 2000);

        queue.subscribe(subscriber1, topic1);
        queue.subscribe(subscriber2, topic1);
        queue.subscribe(subscriber1, topic2);
        queue.subscribe(subscriber3, topic3);
        queue.subscribe(subscriber4, topic4);

        queue.publish(topic1, new Message("m1"));
        queue.publish(topic2, new Message("m2"));
        queue.publish(topic3, new Message("m3"));
        queue.publish(topic4, new Message("m4"));

    }
}
