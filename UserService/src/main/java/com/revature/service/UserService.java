package com.revature.service;

import com.revature.dto.UserPaymentInfo;
import com.revature.pojo.Payment;
import com.revature.pojo.User;

public interface UserService {


	public UserPaymentInfo getUserInfo(String emailAddres, String password);
	
	public int registerNewUser(User user);
	
	public boolean addPaymentInfo(Payment paymentInfo);
}
