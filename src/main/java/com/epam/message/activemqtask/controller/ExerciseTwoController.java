package com.epam.message.activemqtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.message.activemqtask.jms.exercise2.LowerCaseProducer;

@RequestMapping(value = "converter")
@RestController
public class ExerciseTwoController {

    @Autowired
    private LowerCaseProducer lowerCaseProducer;
    
    @GetMapping
    public String convert(@RequestParam(value = "text", defaultValue = "hue") String text) {
        final var upperCaseText = lowerCaseProducer.convertToUpperCase(text);
        return upperCaseText;
    }
}
