package com.revature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.dao.UserDaoImpl;
import com.revature.dto.UserPaymentInfo;
import com.revature.mapper.UserPaymentInfoRowMapper;
import com.revature.pojo.Payment;
import com.revature.pojo.User;

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
	void testGetUserInfo() {

		String sql = "select ua.user_id, ua.first_name, ua.last_name, ua.phone_number, ua.email_address,"
				+ " p.credit_card_type , p.credit_card_number , p.security_code from user_account ua"
				+ " inner join payment p on p.user_id = ua.user_id"
				+ " where ua.email_address = ? and ua.user_password = ?";
		
		String emailAddress = "iyad@shobaki.com";
		String password = "1234";
		
		UserPaymentInfo userPaymentInfoExpected = new UserPaymentInfo(1,"Iyad","Shobaki", "(629) 6437827",
				"iyad@shobaki.com", "jcb", "3547271992417536","322");

		UserPaymentInfo userPaymentInfoReturn = userDaoImpl.getUserInfo(emailAddress, password);

		verify(jdbcTemplate).queryForObject(sql, userPaymentInfoRowMapper, emailAddress, password);

		assertEquals(userPaymentInfoExpected ,userPaymentInfoReturn);

	}
	
	@Test
	void testRegisterNewUser() {
		
//		String sql = "insert into user_account (first_name, last_name, phone_number, email_address, user_password)"
//				+ " values (?,?,?,?,?);";
		
		User userExpected = new User("Mike", "Tyson", "(333) 4441111", "mike@tyson.com", "1234");
		
		int generatedUserId = userDaoImpl.registerNewUser(userExpected);
		
		String sqlVerify = "select email_address from user_account where user_id = ?";
		
		Map<String, Object> map= jdbcTemplate.queryForMap(sqlVerify, generatedUserId);	
		
		String emailAddressReturned = (String) map.get("email_address");
		
		assertTrue(userExpected.getEmailAddress().equals(emailAddressReturned));
		
//		verify(jdbcTemplate.update(sql, user));
		
		
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		
//		verify(jdbcTemplate.update(connection -> {
//			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			ps.setString(1, user.getFirstName());
//			ps.setString(2, user.getLastName());
//			ps.setString(3, user.getPhoneNumber());
//			ps.setString(4, user.getEmailAddress());
//			ps.setString(5, user.getPassword());
//			return ps;
//			
//		}, keyHolder));
		
//		assertTrue(generatedUserId > 0);
		
	}
	
	@Test
	void testAddPaymentInfo() {
		
		String sql = "insert into payment (credit_card_type, credit_card_number, security_code, user_id)"
				+ " values (?, ?, ?, ?);";
		
		Payment paymentInfo = new Payment("Visa", "1234567890123456", "123", 2);
		
		Object[] args = new Object[] {paymentInfo.getCreditCardType(), paymentInfo.getCreditCardNumber(),
				paymentInfo.getSecurityCode(), paymentInfo.getUserId()};
		
		Boolean resultBoolean = userDaoImpl.addPaymentInfo(paymentInfo);
		
		
		//verify(spy(jdbcTemplate.update(sql, args)));

		assertTrue(resultBoolean);
	}
	
}
