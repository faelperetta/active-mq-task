package com.epam.message.activemqtask.jms.exercise3;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessorConsumerListener {

    private static final String CONSUMER_QUEUE_1 = "Consumer.myConsumer1.VirtualTopic.order-topic";
    private static final String CONSUMER_QUEUE_2 = "Consumer.myConsumer2.VirtualTopic.order-topic";

    @JmsListener(destination = CONSUMER_QUEUE_1)
    public void receiveOrder(final String message) {
        System.out.println("Consumer 1 order: %s".formatted(message));
    }
    
    @JmsListener(destination = CONSUMER_QUEUE_1)
    public void receiveOrder1(final String message) {
        System.out.println("Consumer 1.1 order: %s".formatted(message));
    }

    @JmsListener(destination = CONSUMER_QUEUE_2)
    public void receiveOrder2(final String message) {
        System.out.println("Consumer 2 order: %s".formatted(message));
    }
}
