package com.epam.message.activemqtask.jms.exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessorConsumerListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessorConsumerListener.class);

    private static final String CONSUMER_QUEUE_1 = "Consumer.myConsumer1.VirtualTopic.order-topic";
    private static final String CONSUMER_QUEUE_2 = "Consumer.myConsumer2.VirtualTopic.order-topic";

    @JmsListener(destination = CONSUMER_QUEUE_1)
    public void receiveOrder(final String message) {
        LOGGER.info("Consumer 1 order: {}", message);
    }
    
    @JmsListener(destination = CONSUMER_QUEUE_1)
    public void receiveOrder1(final String message) {
        LOGGER.info("Consumer 1.1 order: {}", message);
    }

    @JmsListener(destination = CONSUMER_QUEUE_2)
    public void receiveOrder2(final String message) {
        LOGGER.info("Consumer 2 order: {}", message);
    }
}
