package com.revature.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.dao.UserDaoImpl;
import com.revature.mapper.UserPaymentInfoExtractor;
import com.revature.mapper.UserPaymentInfoRowMapper;

@Profile("test")
@Configuration
public class TestConfig {

	@Bean
	public JdbcTemplate mockJdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}
	
	@Bean
	public UserPaymentInfoRowMapper mockUserPaymentInfoRowMapper() {
		return Mockito.mock(UserPaymentInfoRowMapper.class);
	}
	
	@Bean
	public UserPaymentInfoExtractor mockUserPaymentInfoExtractor() {
		return Mockito.mock(UserPaymentInfoExtractor.class);
	}
	
	@Bean
	public UserDaoImpl mockUserDaoImpl(JdbcTemplate mockJdbcTemplate,
			UserPaymentInfoRowMapper mockUserPaymentInfoRowMapper,
			UserPaymentInfoExtractor mockUserPaymentInfoExtractor) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		userDaoImpl.setJdbcTemplatec(mockJdbcTemplate);
		userDaoImpl.setUserPaymentInfoRowMapper(mockUserPaymentInfoRowMapper);
		
		
		return userDaoImpl;
	}
}
