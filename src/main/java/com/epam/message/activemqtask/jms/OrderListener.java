package com.epam.message.activemqtask.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @JmsListener(destination = "order.queue")
    public void receiveOrder(final String message) {
        System.out.println("Receiver order: %s".formatted(message));
    }
    
}
