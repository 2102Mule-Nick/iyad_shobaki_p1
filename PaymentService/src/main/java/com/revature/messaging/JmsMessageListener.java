package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.revature.config.AppConfig;
import com.revature.dto.UserPaymentInfo;
import com.revature.sevice.HandlePaymentService;

@Service
public class JmsMessageListener {

	private HandlePaymentService handlePaymentService;

	@Autowired
	public void setHandlePaymentService(HandlePaymentService handlePaymentService) {
		this.handlePaymentService = handlePaymentService;
	}
	
	@JmsListener(destination = AppConfig.PAYMENT_INFO_QUEUE)
	public void onBookingServiceMessage(Message message) {
		
		System.out.println("Handling Booking Service Message...");
		
		if(message instanceof ObjectMessage) {
			ObjectMessage om = (ObjectMessage) message; 
			try {
				
				UserPaymentInfo paymentInfo = (UserPaymentInfo) om.getObject();
				handlePaymentService.handleUSerPaymentInfo(paymentInfo);
				
			} catch (JMSException e) {
				//log -- IYAD
			}
		}
	}
	
}
