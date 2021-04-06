package com.revature.config;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.revature.messaging.JmsMessageListener;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import bitronix.tm.resource.jms.PoolingConnectionFactory;

@Configuration
@ComponentScan("com.revature") // searches in that package, and any nested packages for Spring annotations
@EnableJms
@EnableTransactionManagement
public class AppConfig {

	// JMS Broker Url
		public static final String BROKER_URL = "tcp://localhost:61616";

		// JMS Destinations
		public static final String PAYMENT_INFO_QUEUE = "PAYMENT_INFO_QUEUE";
		public static final String PAYMENT_APPROVAL_TOPIC = "PAYMENT_APPROVAL_TOPIC";
		
		public static final String PAYMENT_TEST_QUEUE = "PAYMENT_TEST_QUEUE";

		// DataSource info
		public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/"
				+ System.getenv("BOOKING_DB_TEST_NAME");
		public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";
		public static final String DATASOURCE_USERNAME = System.getenv("DB_USERNAME");
		public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASSWORD");
		public static final String DATASOURCE_SCHEMA = "public";

		@Bean(destroyMethod = "close")
		public DataSource dataSource() {

			PoolingDataSource dataSource = new PoolingDataSource();
			dataSource.setClassName(DATASOURCE_DRIVERNAME);
			dataSource.setUniqueName("BookingPostGresDB");
			dataSource.setMaxPoolSize(10);
			dataSource.setAllowLocalTransactions(true);
			dataSource.getDriverProperties().put("Url", DATASOURCE_URL);
			dataSource.getDriverProperties().put("user", DATASOURCE_USERNAME);
			dataSource.getDriverProperties().put("password", DATASOURCE_PASSWORD);
			dataSource.init();
			return dataSource;

		}

		@Bean
		public JdbcTemplate jdbcTemplate(DataSource dataSource) {
			return new JdbcTemplate(dataSource);
		}

		@Bean
		public ConnectionFactory bitronixConnectionFactory() {
			PoolingConnectionFactory connectionFactory = new PoolingConnectionFactory();
			connectionFactory.setClassName("org.apache.activemq.ActiveMQXAConnectionFactory");
			connectionFactory.setUniqueName("activemq");
			connectionFactory.setMaxPoolSize(10);
			
			//connectionFactory.setUser("admin");
			//connectionFactory.setPassword("admin");
			
			connectionFactory.setAllowLocalTransactions(true);
			Properties props = new Properties();
			props.put("brokerURL", BROKER_URL);
			connectionFactory.setDriverProperties(props);
			return connectionFactory;
		}

		@Bean
		public Queue paymentInfoQueue() {
			return new ActiveMQQueue(PAYMENT_INFO_QUEUE);
		}

		@Bean
		public JmsTemplate jmsTemplate(ConnectionFactory bitronixConnectionFactory) { //@Qualifier("bitronixConnectionFactory") ConnectionFactory bitronixConnectionFactory) {
			JmsTemplate jmsTemplate = new JmsTemplate();
			jmsTemplate.setConnectionFactory(bitronixConnectionFactory);
			jmsTemplate.setReceiveTimeout(10000);
			return jmsTemplate;
		}

		//this will allow us to consume messages from the queue, using Spring for help
		// Generic
		@Bean
		public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory bitronixConnectionFactory,
				JtaTransactionManager jtaTransactionManager) {//@Qualifier("bitronixConnectionFactory") ConnectionFactory connectionFactory) {
			DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
			container.setConnectionFactory(bitronixConnectionFactory);
			container.setTransactionManager(jtaTransactionManager);
			
			//container.setSessionTransacted(true);
			container.setPubSubDomain(true);
			//container.setPubSubDomain(false);
			//container.setConcurrency("1-1");
			return container;
		}

//		
//		@Bean
//		public DefaultMessageListenerContainer jmsContainer(ConnectionFactory bitronixConnectionFactory,
//				JmsMessageListener jmsMessageListener) {
//			DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//			container.setConnectionFactory(bitronixConnectionFactory);
//			container.setDestinationName(PAYMENT_TEST_QUEUE);
//			//container.setPubSubDomain(true);
//			container.setMessageListener(jmsMessageListener);
//			return container;
//		}

		@Bean
		public bitronix.tm.Configuration btmConfig() {
			bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
			config.setDisableJmx(true);
			config.setServerId("spring-btm");
			return config;
		}

		@Bean(destroyMethod = "shutdown")
		@DependsOn("btmConfig")
		public TransactionManager primaryTransactionManager() {
			return TransactionManagerServices.getTransactionManager();
		}

		@Bean
		public JtaTransactionManager jtaTransactionManager(TransactionManager primaryTransactionManager) {
			JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
			jtaTransactionManager.setTransactionManager(primaryTransactionManager);
			return jtaTransactionManager;
		}


		@Bean
		public Logger log() {
			return Logger.getRootLogger();
		}
}
