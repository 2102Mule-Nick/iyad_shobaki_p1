package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.revature.config.AppConfig;
import com.revature.service.SendingEmailsService;

@Component
public class JmsMessageListener {

	private SendingEmailsService sendingEmailsService;
	
	@Autowired
	public void setSendingEmailsService(SendingEmailsService sendingEmailsService) {
		this.sendingEmailsService = sendingEmailsService;
	}



	@JmsListener(destination = AppConfig.PAYMENT_APPROVAL_TOPIC)
	public void onBookingServiceMessage(Message message) {

		System.out.println("Handling Payment Service Message....");
		if (message instanceof TextMessage) {

			try {
				String text = ((TextMessage) message).getText();
				System.out.println("PaymentService send a message of: " + text);
				//sendingEmailsService.sendEmailToUserAndHotel("userEmail", "hotelEmail",text);
				sendingEmailsService.sendEmailToUserAndHotel(text);
			} catch (JMSException e) {
				// log -- IYAD
			}
		}
	}
	
}
