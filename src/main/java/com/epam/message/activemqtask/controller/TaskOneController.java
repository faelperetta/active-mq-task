package com.epam.message.activemqtask.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "orders")
public class TaskOneController {

    private static final String ORDER_TOPIC = "order.topic";
    
    private final JmsTemplate jmsTemplate;

    public TaskOneController(@Qualifier("pubJmsTemplate") final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping
    public String sendSimpleOrderAsText(@RequestParam("order") final String order) {
        jmsTemplate.convertAndSend(ORDER_TOPIC, order);
        return "success";
    }
}
