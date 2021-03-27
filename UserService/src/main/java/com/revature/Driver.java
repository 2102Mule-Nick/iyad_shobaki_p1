package com.revature;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.dto.UserPaymentInfo;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService userService = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
		
		UserPaymentInfo paymentInfo = userService.getUserInfo("iyad@shobaki.com", "1234");
		System.out.println(paymentInfo);
		
	}

}
