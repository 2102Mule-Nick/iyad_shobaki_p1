package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.dto.UserPaymentInfo;
import com.revature.pojo.Payment;
import com.revature.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserPaymentInfo getUserInfo(String emailAddres, String password) {
		return userDao.getUserInfo(emailAddres, password);
	}

	@Override
	public int registerNewUser(User user) {
		return userDao.registerNewUser(user);
	}

	@Override
	public boolean addPaymentInfo(Payment paymentInfo) {
		return userDao.addPaymentInfo(paymentInfo);
	}

}
