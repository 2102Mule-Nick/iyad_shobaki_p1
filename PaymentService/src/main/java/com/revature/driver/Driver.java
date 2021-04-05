package com.revature.driver;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
//import com.revature.messaging.JmsMessageSender;

public class Driver {

	public static void main(String[] args) {

//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//
//		JmsMessageSender sender = applicationContext.getBean("jmsMessageSender", JmsMessageSender.class);
//		sender.sendPaymentApprovedOrDeclined("Approved");

		System.out.println("PaymentService starting up...");

		String command = null;

		Scanner scan = new Scanner(System.in);

		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		while (!"exit".equals(command)) {
			// just listening for messages
			command = scan.nextLine();
		}
	}
}
