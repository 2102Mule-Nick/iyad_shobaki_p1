package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.config.AppConfig;
import com.revature.service.BookingService;
import com.revature.service.BookingServiceImpl;

@Component
public class JmsMessageListener {// implements MessageListener{

	private BookingService bookingService;
	
	
	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@Transactional // (rollbackFor = Exception.class)
	@JmsListener(destination = AppConfig.PAYMENT_APPROVAL_TOPIC)//, containerFactory = "jmsListenerContainerFactory")
	public void onPaymentApproval(Message message) {

		System.out.println("Handling Payment Service Message....");
		if (message instanceof TextMessage) {

			try {
				String text = ((TextMessage) message).getText();
				//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! PaymentService send a message of: " + text);
				bookingService.setPaymentApproval(text);
			} catch (JMSException e) {
				// log -- IYAD
			}
		}
	}

//	@Override
//	@Transactional
//	public void onMessage(Message message) {
//		
//		//System.out.println("Handling Payment Service Message....");
//		if(message instanceof TextMessage) {
//			
//			try {
//				 String text = ((TextMessage)message).getText();
//				 System.out.println("PaymentService send a message of: " + text);
//				 //BookingServiceImpl.paymentStatus = text;
//				 
//			} catch (JMSException e) {
//				System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + e.getMessage());
//				//log -- IYAD
//			}
//		}
//		
//	}

}
