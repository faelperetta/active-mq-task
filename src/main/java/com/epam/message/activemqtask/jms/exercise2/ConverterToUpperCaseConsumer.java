package com.epam.message.activemqtask.jms.exercise2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConverterToUpperCaseConsumer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterToUpperCaseConsumer.class);
    
    @JmsListener(destination = "convert.queue")
    public String toUpperCase(Message message) throws JMSException {
        final var tempQueue = (ActiveMQDestination) message.getJMSReplyTo();
        
        LOGGER.info("Temporary queue physical name to reply to: {}", tempQueue.getPhysicalName());
        LOGGER.info("Temporary queue quialified name to reply to: {}", tempQueue.getQualifiedName());
    
        final var textMessage = ((TextMessage) message).getText();
        
        return textMessage.toUpperCase();
    }
}
