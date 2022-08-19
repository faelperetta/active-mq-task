package com.epam.message.activemqtask.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConverterToUpperCaseConsumer {
    @JmsListener(destination = "convert.queue")
    public String toUpperCase(String message) {
        return message.toUpperCase();
    }
}
