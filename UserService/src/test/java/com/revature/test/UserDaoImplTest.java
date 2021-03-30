package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.dao.UserDaoImpl;
import com.revature.dto.UserPaymentInfo;
import com.revature.mapper.UserPaymentInfoRowMapper;
import com.revature.pojo.Payment;
import com.revature.pojo.User;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfig.class })
class UserDaoImplTest {

	@Autowired
	JdbcTemplate mockJdbcTemplate;
	@Autowired
	UserDaoImpl userDaoImpl;
	@Autowired
	UserPaymentInfoRowMapper mockUserPaymentInfoRowMapper;
	
	@Captor
	ArgumentCaptor<Object[]> objetCaptured;
	@Captor
	ArgumentCaptor<int[]> intCaptured;

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

		String sql = "select ua.user_id, ua.first_name, ua.last_name, ua.phone_number, ua.email_address,"
				+ " p.credit_card_type , p.credit_card_number , p.security_code from user_account ua"
				+ " inner join payment p on p.user_id = ua.user_id"
				+ " where ua.email_address = ? and ua.user_password = ?";

		UserPaymentInfo userPaymentInfo = new UserPaymentInfo(1, "Iyad", "Shobaki", "(333) 4441111", "iyad@shobaki.com",
				"Visa", "1234567890123456", "322");
		String emailAddress = "iyad@shobaki.com";
		String password = "1234";

		when(mockJdbcTemplate.queryForObject(sql, mockUserPaymentInfoRowMapper, emailAddress, password))
				.thenReturn(userPaymentInfo);

		UserPaymentInfo userPaymentInfoReturn = userDaoImpl.getUserInfo(emailAddress, password);

		verify(mockJdbcTemplate).queryForObject(sql, mockUserPaymentInfoRowMapper, emailAddress, password);

		assertEquals(userPaymentInfo, userPaymentInfoReturn);

	}

	// Not working as expected -- IYAD
	@Test 
	void testRegisterNewUser() {

		String sql = "insert into user_account (first_name, last_name, phone_number, email_address, user_password)"
				+ " values (?,?,?,?,?);";

		String firstName = "Mike";
		String lastName = "Tyson";
		String phoneNumber = "(330) 6678899";
		String emailAddress = "mike@tyson.com";
		String password = "1234";

		User user = new User(firstName, lastName, phoneNumber, emailAddress, password);

		//int generatedId = 1;
		

		//KeyHolder keyHolder = new GeneratedKeyHolder();
		when(mockJdbcTemplate.update(sql, user)).thenReturn(1);

	KeyHolder keyHolder = new GeneratedKeyHolder();
		
		when(mockJdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPhoneNumber());
			ps.setString(4, user.getEmailAddress());
			ps.setString(5, user.getPassword());
			return ps;
			
		}, keyHolder)).thenReturn(1);
		
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		when(mockJdbcTemplate.update(connection -> {
//			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1, user.getFirstName());
//			ps.setString(2, user.getLastName());
//			ps.setString(3, user.getPhoneNumber());
//			ps.setString(4, user.getEmailAddress());
//			ps.setString(5, user.getPassword());
//			return ps;
//		}, keyHolder)).thenAnswer(new Answer() {
//			public Object answer(InvocationOnMock invocation) {
//				Object[] args = invocation.getArguments();
//				Map<String, Object> keyMap = new HashMap<String, Object>();
//				keyMap.put("", generatedId);
//				((GeneratedKeyHolder) args[2]).getKeyList().add(keyMap);
//
//				return 1;
//			}
//		}).thenReturn(1);

		int userIDReturn = userDaoImpl.registerNewUser(user);

		verify(mockJdbcTemplate.update(sql, user));

//		assertEquals(userIDReturn, 1);
		assertTrue(userIDReturn == 1);

	}

	// Not working as expected -- IYAD
	@Test
	void testAddPaymentInfo() {

		String sql = "insert into payment (credit_card_type, credit_card_number, security_code, user_id)"
				+ " values (?, ?, ?, ?);";

		Payment paymentInfo = new Payment("mastercard", "1234567890123456", "111", 1);

		Object[] args = new Object[] { paymentInfo.getCreditCardType(), paymentInfo.getCreditCardNumber(),
				paymentInfo.getSecurityCode(), paymentInfo.getUserId() };

		when(mockJdbcTemplate.update(sql, args)).thenReturn(1);

		Boolean booleanReturn = userDaoImpl.addPaymentInfo(paymentInfo);

		verify(mockJdbcTemplate.update(sql, args));

		assertTrue(booleanReturn);

	}

}
