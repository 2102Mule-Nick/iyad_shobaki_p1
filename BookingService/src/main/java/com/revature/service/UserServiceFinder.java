package com.revature.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.dto.UserPaymentInfo;
import com.revature.pojo.Payment;
import com.revature.pojo.User;

@Service
public class UserServiceFinder {

	RestTemplate restTemplate = new RestTemplate();
	
	public ResponseEntity<UserPaymentInfo> getUserInfo(String emailAddres, String password) {
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("username", emailAddres);
		headers.add("password", password);
		
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		
		return restTemplate.exchange("http://localhost:8080/UserService/user",
				HttpMethod.GET, entity, UserPaymentInfo.class);
	}

	public ResponseEntity<String> registerNewUser(User user) {
		
		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<User> entity = new HttpEntity<>(user, headers);
		
		return restTemplate.exchange("http://localhost:8080/UserService/user",
				HttpMethod.POST, entity, String.class);
		
		
	}
	

	public ResponseEntity<String> addPaymentInfo(Payment payment) {
		
		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<Payment> entity = new HttpEntity<>(payment, headers);
		
		return restTemplate.exchange("http://localhost:8080/UserService/user/payment",
				HttpMethod.POST, entity, String.class);
		
		
	}
}
