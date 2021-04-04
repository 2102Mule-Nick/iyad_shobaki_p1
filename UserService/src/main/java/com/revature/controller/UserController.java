package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dto.UserPaymentInfo;
import com.revature.pojo.Payment;
import com.revature.pojo.User;
import com.revature.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping(path = "/user")
	@ResponseBody
	public UserPaymentInfo getUserInfoByEmailAndPassword(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {
		return userService.getUserInfo(username, password);
	}
	
	@PostMapping("/user")
	@ResponseBody
	public String registerNewUser(@RequestBody User user) {
		
		if(userService.registerNewUser(user) > 0) {
			return "User register successfully!";
		}
		return "Something went wrong. Please try again";
		
		
	}
	
	@PostMapping("/user/payment")
	@ResponseBody
	public String addUserPaymentInfo(@RequestBody Payment payment) {
		
		if(userService.addPaymentInfo(payment)) {
			return "Payment info inserted successfully!";
		}
		return "Something went wrong. Please try again";
		
		
	}
}
