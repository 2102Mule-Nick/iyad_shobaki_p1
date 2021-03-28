package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import com.revature.dao.HotelDaoImpl;
import com.revature.mapper.HotelRowMapper;
import com.revature.pojo.Hotel;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfig.class })
class HotelDaoImplTest {
	
	@Autowired
	JdbcTemplate mockJdbcTemplate;
	
	@Autowired
	HotelRowMapper hotelRowMapper;

	@Autowired
	HotelDaoImpl hotelDaoImpl;

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
	void testGetAllHotels() {
		
		String sql = "select * from hotel";
		
		List<Hotel> hotelList = new ArrayList<>();
		
		Hotel hotel = new Hotel(1,"Hotel Name", "email@address.com", "Ohio", "Lakewood", "123 Main st");
		hotelList.add(hotel);
		
		when(mockJdbcTemplate.query(sql, hotelRowMapper)).thenReturn(hotelList);
		
		List<Hotel> hotelListReturn = hotelDaoImpl.getAllHotels();
		
		verify(mockJdbcTemplate).query(sql, hotelRowMapper);
		
		assertFalse(hotelListReturn.isEmpty());
	}

	@Test
	void testGetAllHotelsByState() {
		
		String sql = "select * from hotel where state = ?";
		String state = "Ohio";
		
		List<Hotel> hotelList = new ArrayList<>();
		
		Hotel hotel = new Hotel(1,"Hotel Name", "email@address.com", "Ohio", "Lakewood", "123 Main st");
		hotelList.add(hotel);
		
		when(mockJdbcTemplate.query(sql, hotelRowMapper, state)).thenReturn(hotelList);
		
		List<Hotel> hotelListReturn = hotelDaoImpl.getAllHotelsByState("Ohio");
		
		verify(mockJdbcTemplate).query(sql, hotelRowMapper, state);
		
		assertFalse(hotelListReturn.isEmpty());
		
		
	}

}
