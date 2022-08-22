package com.epam.message.activemqtask.jms.exercise3;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class VirtualTopicOrderProducer {

    private static final ActiveMQTopic VIRTUAL_TOPIC = new ActiveMQTopic("VirtualTopic.order-topic");

    private final JmsTemplate jmsTemplate;

    public VirtualTopicOrderProducer(@Qualifier("jmsTemplatePersistent") final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final String message) {
        jmsTemplate.convertAndSend(VIRTUAL_TOPIC, message);
    }
    
}
