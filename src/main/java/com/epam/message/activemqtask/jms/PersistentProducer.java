package com.epam.message.activemqtask.jms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersistentProducer {

    private final JmsTemplate jmsTemplate;

    public PersistentProducer(@Qualifier("jmsTemplatePersistent") JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send() {
        jmsTemplate.convertAndSend("order.queue", "test " + System.currentTimeMillis());
    }
    
}
