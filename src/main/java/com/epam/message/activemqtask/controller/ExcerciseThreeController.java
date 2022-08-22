package com.epam.message.activemqtask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.message.activemqtask.jms.exercise3.VirtualTopicOrderProducer;


@RestController
@RequestMapping(value = "virtual")
public class ExcerciseThreeController {

    private final VirtualTopicOrderProducer virtualTopicProducer;

    public ExcerciseThreeController(final VirtualTopicOrderProducer virtualTopicProducer) {
        this.virtualTopicProducer = virtualTopicProducer;
    }

    @GetMapping
    public String sendMessage(@RequestParam(defaultValue = "my order") String order) {
        this.virtualTopicProducer.send(order);
        return "success";
    }
    
    
}
