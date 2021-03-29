package com.revature;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.dto.UserPaymentInfo;
import com.revature.pojo.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService userService = applicationContext.getBean("userServiceImpl", UserServiceImpl.class);
		
		// Working fine
//		UserPaymentInfo paymentInfo = userService.getUserInfo("iyad@shobaki.com", "1234");
//		System.out.println(paymentInfo);
//		
		// Working fine
//		String firstName = "Mike";
//		String lastName = "Tyson";
//		String phoneNumber = "(330) 6678899";
//		String emailAddress = "mike@tyson.com";
//		String password = "1234";
//		User user = new User(firstName,lastName,phoneNumber,emailAddress,password);
//		
//		int userId = userService.registerNewUser(user);
//		
//		System.out.println(userId);
		
	}

}
