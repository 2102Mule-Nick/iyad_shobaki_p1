package com.revature.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.dto.UserPaymentInfo;

@Component
public class UserPaymentInfoRowMapper implements RowMapper<UserPaymentInfo> {

	private UserPaymentInfoExtractor userPaymentInfoExtractor;
	
	@Autowired
	public void setUserPaymentInfoExtractor(UserPaymentInfoExtractor userPaymentInfoExtractor) {
		this.userPaymentInfoExtractor = userPaymentInfoExtractor;
	}


	@Override
	public UserPaymentInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		return userPaymentInfoExtractor.extractData(rs);
	}

}
