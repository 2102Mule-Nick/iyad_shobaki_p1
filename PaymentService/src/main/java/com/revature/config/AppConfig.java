package com.revature.config;


import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;


@Configuration
@ComponentScan("com.revature")
@EnableAspectJAutoProxy
@EnableJms
public class AppConfig {
	
	public static final String BROKER_URL = "tcp://localhost:61616";
	
	public static final String PAYMENT_INFO_QUEUE = "PAYMENT_INFO_QUEUE";
	public static final String EXAMPLE_TOPIC = "EXAMPLE_TOPIC";
	

	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
	
	@Bean
	public ActiveMQConnectionFactory amqConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
		//connectionFactory.setTrustAllPackages(true);
		return connectionFactory;
	}
	
	@Bean
	public ConnectionFactory connectionFactory(ActiveMQConnectionFactory amqConnectionFactory) {
		return new SingleConnectionFactory(amqConnectionFactory);
	}
	
//	@Bean
//	public Queue destinationQueue() {
//		return new ActiveMQQueue(EXAMPLE_QUEUE);
//	}
//	
//	@Bean
//	public Topic destinationTopic() {
//		return new ActiveMQTopic(EXAMPLE_TOPIC);
//	}
//	
	
	
	//this will allow us to consume messages from the queue, using Spring for help
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
		container.setConnectionFactory(connectionFactory);
		return container;
	}
	
}

