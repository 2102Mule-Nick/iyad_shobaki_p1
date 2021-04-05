//package com.revature.messaging;
//
//
//import javax.jms.Queue;
//import javax.jms.Topic;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JmsMessageSender {
//
//	private JmsTemplate jmsTemplate;
//
////	private Topic paymentApprovedTopic;
//	
//	private Queue paymentTestQueue;
//	
//	@Autowired
//	public void setJmsTemplate(JmsTemplate jmsTemplate) {
//		this.jmsTemplate = jmsTemplate;
//	}
//
////	@Autowired
////	@Qualifier("paymentApprovedTopic")
////	public void setPaymentApprovedTopic(Topic paymentApprovedTopic) {
////		this.paymentApprovedTopic = paymentApprovedTopic;
////	}
//	
//	@Autowired
//	@Qualifier("paymentTestQueue")
//	public void setPaymentTestQueue(Queue paymentTestQueue) {
//		this.paymentTestQueue = paymentTestQueue;
//	}
//
//	public void sendPaymentApprovedOrDeclined(String msg) {
////		jmsTemplate.send(paymentApprovedTopic, (s) -> s.createTextMessage(msg));
//		jmsTemplate.send(paymentTestQueue, (s) -> s.createTextMessage(msg));
//	}
//}
