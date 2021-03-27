package com.revature.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.dto.UserPaymentInfo;

@Component
public class UserPaymentInfoExtractor implements ResultSetExtractor<UserPaymentInfo> {

	@Override
	public UserPaymentInfo extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		UserPaymentInfo userPaymentInfo = new UserPaymentInfo(
				rs.getInt("user_id"), 
				rs.getString("first_name"),
				rs.getString("last_name"),
				rs.getString("phone_number"),
				rs.getString("email_address"),
				rs.getString("credit_card_type"),
				rs.getString("credit_card_number"),
				rs.getString("security_code"));
		
		return userPaymentInfo;
	}

}
