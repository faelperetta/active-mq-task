package com.epam.message.activemqtask.jms.exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderLogListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderLogListener.class);

    @JmsListener(
        destination = "order.topic", 
        containerFactory = "nonDurableTopicFactory", 
        subscription = "order-log-subscription"
    )
    public void receiveOrderFromTopic(final String message) {
        LOGGER.info("Logging order information: {}", message);
    }
    
}
