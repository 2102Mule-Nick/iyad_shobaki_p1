package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.dao.UserDaoImpl;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
class UserDaoImplTest {

	@Autowired
	JdbcTemplate mockJdbcTemplate;
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetUserInfo() {
		
//		String sql = "select ua.user_id, ua.first_name, ua.last_name, ua.phone_number, ua.email_address,"
//				+ " p.credit_card_type , p.credit_card_number , p.security_code from user_account ua"
//				+ " inner join payment p on p.user_id = ua.user_id"
//				+ " where ua.email_address = ? and ua.user_password = ?";
//		
//		
//
//		return jdbcTemplatec.queryForObject(sql, userPaymentInfoRowMapper, emailAddres, password);
	
	}

	@Test
	void testRegisterNewUser() {
		fail("Not yet implemented");
	}

	@Test
	void testAddPaymentInfo() {
		fail("Not yet implemented");
	}

}
