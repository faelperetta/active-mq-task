package com.epam.message.activemqtask.jms.exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * This OrdeSendEmailListener uses a different container factory for durable subscription
 */
@Component
public class OrderSendEmailListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSendEmailListener.class);

    @JmsListener(
        destination = "order.topic", 
        containerFactory = "durableTopicFactory", 
        subscription = "order-send-email-subscription"
    )
    public void receiveOrderFromTopic(final String message) {
        LOGGER.info("Sending email with order information: {}", message);
    }
    
}
