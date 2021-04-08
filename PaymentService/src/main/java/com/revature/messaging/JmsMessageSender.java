package com.revature.messaging;


import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageSender {

	private JmsTemplate jmsTemplate;

	private Topic paymentApprovalTopic;
	
	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Autowired
	public void setPaymentApprovalTopic(Topic paymentApprovalTopic) {
		this.paymentApprovalTopic = paymentApprovalTopic;
	}

	public void sendPaymentApprovedOrDeclined(String msg) {
		jmsTemplate.send(paymentApprovalTopic, (s) -> s.createTextMessage(msg));
	}
}
