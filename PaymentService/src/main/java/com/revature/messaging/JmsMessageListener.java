package com.revature.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.config.AppConfig;
import com.revature.dto.UserPaymentInfo;
import com.revature.sevice.HandlePaymentService;

@Component
public class JmsMessageListener {// implements MessageListener{

	private HandlePaymentService handlePaymentService;

	@Autowired
	public void setHandlePaymentService(HandlePaymentService handlePaymentService) {
		this.handlePaymentService = handlePaymentService;
	}

	@JmsListener(destination = AppConfig.PAYMENT_INFO_QUEUE)
	public void onBookingServiceMessage(Message message) {

		System.out.println("Handling Booking Service Message...");

		//System.out.println(message);
		if (message instanceof ObjectMessage) {

			// System.out.println("Reach here !!!!!!!!!!!!!!!!!");
			ObjectMessage om = (ObjectMessage) message;
			//System.out.println(om);
			try {

				UserPaymentInfo paymentInfo = (UserPaymentInfo) om.getObject();
				//System.out.println(paymentInfo.getEmailAddress());
				handlePaymentService.handleUSerPaymentInfo(paymentInfo);
//				System.out.println(paymentInfo);
			} catch (JMSException e) {

				System.out.println(e.getMessage());
				// log -- IYAD
			}
		}
	}

//	@Override
//	public void onMessage(Message message) {
//		System.out.println("Handling Booking Service Message...");
//		
//		System.out.println(message);
//		if(message instanceof ObjectMessage) {
//			
//			//System.out.println("Reach here !!!!!!!!!!!!!!!!!");
//			ObjectMessage om = (ObjectMessage) message; 
//			System.out.println(om);
//			try {
//				
//				UserPaymentInfo paymentInfo = (UserPaymentInfo) om.getObject();
//				handlePaymentService.handleUSerPaymentInfo(paymentInfo);
//				System.out.println(paymentInfo);
//			} catch (JMSException e) {
//				
//				System.out.println(e.getMessage());
//				//log -- IYAD
//			}
//		}		
//	}

}
