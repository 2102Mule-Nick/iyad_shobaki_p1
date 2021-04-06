package com.revature.config;


import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import com.revature.messaging.JmsMessageListener;


@Configuration
@ComponentScan("com.revature")
@EnableAspectJAutoProxy
@EnableJms
public class AppConfig {
	
	public static final String BROKER_URL = "tcp://localhost:61616";
	
	public static final String PAYMENT_INFO_QUEUE = "PAYMENT_INFO_QUEUE";
	//public static final String PAYMENT_TEST_QUEUE = "PAYMENT_TEST_QUEUE";
	public static final String PAYMENT_APPROVAL_TOPIC = "PAYMENT_APPROVAL_TOPIC";
	

	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
	
	@Bean
	public ActiveMQConnectionFactory amqConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
		connectionFactory.setTrustAllPackages(true);
		return connectionFactory;
	}
	
	@Bean
	public ConnectionFactory connectionFactory(ActiveMQConnectionFactory amqConnectionFactory) {
		return new SingleConnectionFactory(amqConnectionFactory);
	}
	
	@Bean
	public Topic paymentApprovalTopic() {
		return new ActiveMQTopic(PAYMENT_APPROVAL_TOPIC);
	}
	
//	@Bean
//	public Queue paymentTestQueue() {
//		return new ActiveMQQueue(PAYMENT_TEST_QUEUE);
//	}
//	
	
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory);
		return template;
	}


//	@Bean
//	public DefaultMessageListenerContainer jmsContainer(ConnectionFactory connectionFactory,
//			JmsMessageListener messageListener) {
//		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setDestinationName(PAYMENT_INFO_QUEUE);
////		container.setDestinationName(EXAMPLE_TOPIC);
////		container.setPubSubDomain(true);
////		
//		container.setMessageListener(messageListener);
//		return container;
//	}
	
//	
//	//this will allow us to consume messages from the queue, using Spring for help
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
		container.setConnectionFactory(connectionFactory);
		return container;
	}
	

	
}

