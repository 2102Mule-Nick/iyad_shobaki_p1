//package com.revature.messaging;
//
//import javax.jms.Queue;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//
//import com.revature.dto.UserPaymentInfo;
//
//@Service
//public class JmsMessageSender {
//
//	private JmsTemplate jmsTemplate;
//	
//	private Queue paymentInfoQueue;
//
//	@Autowired
//	public void setJmsTemplate(JmsTemplate jmsTemplate) {
//		this.jmsTemplate = jmsTemplate;
//	}
//
//	@Autowired
//	@Qualifier("paymentInfoQueue")
//	public void setPaymentInfoQueue(Queue paymentInfoQueue) {
//		this.paymentInfoQueue = paymentInfoQueue;
//	}
//	
//	public void sendToPaymentServiceQueue(UserPaymentInfo paymentInfo) {
//		jmsTemplate.send(paymentInfoQueue, (s) -> s.createObjectMessage(paymentInfo));
//	}
//	
//	
//	
//}
