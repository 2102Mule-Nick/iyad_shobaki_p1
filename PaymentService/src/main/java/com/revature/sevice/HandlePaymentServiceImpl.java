package com.revature.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dto.UserPaymentInfo;
import com.revature.messaging.JmsMessageSender;

@Service
public class HandlePaymentServiceImpl implements HandlePaymentService {

	private JmsMessageSender jmsMessageSender;
	
	@Autowired
	public void setJmsMessageSender(JmsMessageSender jmsMessageSender) {
		this.jmsMessageSender = jmsMessageSender;
	}


	@Override
	public void handleUSerPaymentInfo(UserPaymentInfo paymentInfo) {
		// Send a TOPIC to BookingService and NotificationService
		//jmsMessageSender.sendPaymentApprovedOrDeclined("Approved");

	}

}
