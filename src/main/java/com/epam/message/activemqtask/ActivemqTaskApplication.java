package com.epam.message.activemqtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActivemqTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivemqTaskApplication.class, args);
	}
}
