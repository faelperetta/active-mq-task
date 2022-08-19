package com.epam.message.activemqtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.epam.message.activemqtask.jms.LowerCaseProducer;
import com.epam.message.activemqtask.jms.PersistentProducer;

@SpringBootApplication
@EnableJms
public class ActivemqTaskApplication implements CommandLineRunner {

	@Autowired
	private LowerCaseProducer producer;

	@Autowired
	private PersistentProducer persistentProducer;

	@Autowired
	@Qualifier("pubJmsTemplate") 
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ActivemqTaskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.producer.sendMesssage("talkei");
		this.persistentProducer.send();
		jmsTemplate.convertAndSend("order.topic", "TOPIC");
	}

}
