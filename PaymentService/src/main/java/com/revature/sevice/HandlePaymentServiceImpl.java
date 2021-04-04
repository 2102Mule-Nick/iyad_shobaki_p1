package com.revature.sevice;

import org.springframework.stereotype.Service;

import com.revature.dto.UserPaymentInfo;

@Service
public class HandlePaymentServiceImpl implements HandlePaymentService {

	@Override
	public void handleUSerPaymentInfo(UserPaymentInfo paymentInfo) {
		// Send a TOPIC to BookingService and NotificationService
		
		

	}

}
