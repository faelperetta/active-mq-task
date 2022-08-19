package com.epam.message.activemqtask.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SendEmailListener {

    @JmsListener(
        destination = "order.topic", 
        containerFactory = "topicFactory", 
        subscription = "email"
    )
    public void receiveOrderFromTopic(final String message) {
        System.out.println("Sending email: %s".formatted(message));
    }
    
}
