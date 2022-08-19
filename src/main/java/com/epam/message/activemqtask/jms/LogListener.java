package com.epam.message.activemqtask.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LogListener {

    @JmsListener(destination = "order.topic", containerFactory = "topicFactory", subscription = "log")
    public void receiveOrderFromTopic(final String message) {
        System.out.println("Logging information: %s".formatted(message));
    }
    
}
