package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.revature.dto.UserPaymentInfo;
import com.revature.mapper.UserPaymentInfoRowMapper;
import com.revature.pojo.Payment;
import com.revature.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplatec;
	
	private UserPaymentInfoRowMapper userPaymentInfoRowMapper;

	@Autowired
	public void setUserPaymentInfoRowMapper(UserPaymentInfoRowMapper userPaymentInfoRowMapper) {
		this.userPaymentInfoRowMapper = userPaymentInfoRowMapper;
	}

	@Autowired
	public void setJdbcTemplatec(JdbcTemplate jdbcTemplatec) {
		this.jdbcTemplatec = jdbcTemplatec;
	}

	@Override
	public UserPaymentInfo getUserInfo(String emailAddres, String password) {

		String sql = "select ua.user_id, ua.first_name, ua.last_name, ua.phone_number, ua.email_address,"
				+ " p.credit_card_type , p.credit_card_number , p.security_code from user_account ua"
				+ " inner join payment p on p.user_id = ua.user_id"
				+ " where ua.email_address = ? and ua.user_password = ?";

		return jdbcTemplatec.queryForObject(sql, userPaymentInfoRowMapper, emailAddres, password);
	}

	@Override
	public int registerNewUser(User user) {
		
		String sql = "insert into user_account (first_name, last_name, phone_number, email_address, user_password)"
				+ " values (?,?,?,?,?);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplatec.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPhoneNumber());
			ps.setString(4, user.getEmailAddress());
			ps.setString(5, user.getPassword());
			return ps;
			
		}, keyHolder);
		
		int userID = (int)keyHolder.getKeys().get("user_id");
		
		return userID;
	}

	@Override
	public boolean addPaymentInfo(Payment paymentInfo) {
		
		String sql = "insert into payment (credit_card_type, credit_card_number, security_code, user_id)"
				+ " values (?, ?, ?, ?);";
				
		Object[] args = new Object[] {paymentInfo.getCreditCardType(), paymentInfo.getCreditCardNumber(),
				paymentInfo.getSecurityCode(), paymentInfo.getUserId()};
		
		if(jdbcTemplatec.update(sql, args) == 0) {
			return false;
		}
		
		return true;
	}

}
