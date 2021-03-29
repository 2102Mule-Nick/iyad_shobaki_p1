package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.dao.UserDaoImpl;
import com.revature.dto.UserPaymentInfo;
import com.revature.mapper.UserPaymentInfoRowMapper;

@ActiveProfiles("integration-test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {IntegrationConfig.class})
public class UserServiceIntegrationTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	UserPaymentInfoRowMapper userPaymentInfoRowMapper;
	@Autowired
	UserDaoImpl userDaoImpl;
	
	
	// Add more testing cases --- IYAD
	@Test
	void testGetUserInfoNotNull() {

		String sql = "select ua.user_id, ua.first_name, ua.last_name, ua.phone_number, ua.email_address,"
				+ " p.credit_card_type , p.credit_card_number , p.security_code from user_account ua"
				+ " inner join payment p on p.user_id = ua.user_id"
				+ " where ua.email_address = ? and ua.user_password = ?";
		
		String emailAddress = "iyad@shobaki.com";
		String password = "1234";

		UserPaymentInfo userPaymentInfoReturn = userDaoImpl.getUserInfo(emailAddress, password);

		verify(jdbcTemplate).queryForObject(sql, userPaymentInfoRowMapper, emailAddress, password);

		assertNotNull(userPaymentInfoReturn);

	}
}
