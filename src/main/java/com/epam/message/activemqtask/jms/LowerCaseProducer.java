package com.epam.message.activemqtask.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class LowerCaseProducer {

    private static final String CONVERT_QUEUE = "convert.queue";

    private final JmsTemplate jmsTemplate;

    public LowerCaseProducer(@Qualifier("jmsTemplatePersistent") JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public String sendMesssage(String text) {
        TextMessage response = (TextMessage) jmsTemplate.sendAndReceive(CONVERT_QUEUE, (s) -> {
            var message = s.createTextMessage();
            message.setText(text);
            return message;
        } );

        var result = "";

        try {
            result = response.getText();
        } catch (JMSException e) {
            result = "error";
        }

        return result;
    }
    
}
