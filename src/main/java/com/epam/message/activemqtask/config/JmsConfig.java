package com.epam.message.activemqtask.config;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    @Bean
    @Qualifier("topicConnFactory")
    public SingleConnectionFactory topicConnectionFactory(){

        SingleConnectionFactory factory = new SingleConnectionFactory(
                new ActiveMQConnectionFactory(user, password, brokerUrl)
        );
        factory.setReconnectOnException(true);
        factory.setClientId("task-id");
        return factory;
    }

    @Bean
    @Qualifier("jmsTemplatePersistent")
    public JmsTemplate persistentJmsTemplate(ConnectionFactory connectionFactory) {
        final var jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
        return jmsTemplate;
    }

    @Bean
    @Qualifier("pubJmsTemplate")
    public JmsTemplate pubJmsTemplate(ConnectionFactory connectionFactory) {
        final var jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setPubSubDomain(true);
        return jmsTemplate;
    }

    
    @Bean
    public JmsListenerContainerFactory<?> durableTopicFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setConcurrency("1");
        factory.setSubscriptionDurable(true);
        return factory;
    }

    @Bean
    public JmsListenerContainerFactory<?> nonDurableTopicFactory(ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setConcurrency("1");
        return factory;
    }
}
