package com.revature.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.dao.HotelDaoImpl;
import com.revature.dao.RoomDaoImpl;
import com.revature.mapper.HotelExtractor;
import com.revature.mapper.HotelRowMapper;
import com.revature.mapper.RoomNumberExtractor;
import com.revature.mapper.RoomNumberRowMapper;
import com.revature.mapper.RoomTypeExtractor;
import com.revature.mapper.RoomTypeRowMapper;

@Profile("test")
@Configuration
public class TestConfig {

	@Bean
	public JdbcTemplate mockJdbcTemplate() {
		return Mockito.mock(JdbcTemplate.class);
	}
	
	@Bean
	public HotelRowMapper mockHotelRowMapper() {
		return Mockito.mock(HotelRowMapper.class);
	}
	
	@Bean
	public HotelExtractor HotelExtractor() {
		return Mockito.mock(HotelExtractor.class);
	}
	
	@Bean
	public HotelDaoImpl hotelDaoImpl(JdbcTemplate mockJdbcTemplate,
			HotelRowMapper mockHotelRowMapper) {
		HotelDaoImpl hotelDaoImpl = new HotelDaoImpl();
		
		hotelDaoImpl.setJdbcTemplate(mockJdbcTemplate);
		hotelDaoImpl.setHotelRowMapper(mockHotelRowMapper);
		
		return hotelDaoImpl;
	}
	
	@Bean
	public RoomNumberRowMapper mockRoomNumberRowMapper() {
		return Mockito.mock(RoomNumberRowMapper.class);
	}
	@Bean
	public RoomNumberExtractor mockRoomNumberExtractor() {
		return Mockito.mock(RoomNumberExtractor.class);
	}
	
	@Bean
	public RoomTypeRowMapper mockRoomTypeRowMapper() {
		return Mockito.mock(RoomTypeRowMapper.class);
	}
	
	@Bean
	public RoomTypeExtractor mockRoomTypeExtractor() {
		return Mockito.mock(RoomTypeExtractor.class);
	}
	@Bean
	public RoomDaoImpl roomDaoImpl(JdbcTemplate mockJdbcTemplate,
			RoomNumberRowMapper mockRoomNumberRowMapper,
			RoomTypeRowMapper mockRoomTypeRowMapper) {
		RoomDaoImpl roomDaoImpl = new RoomDaoImpl();
		
		roomDaoImpl.setJdbcTemplate(mockJdbcTemplate);
		roomDaoImpl.setRoomNumberRowMapper(mockRoomNumberRowMapper);
		roomDaoImpl.setRoomTypeRowMapper(mockRoomTypeRowMapper);
		
		return roomDaoImpl;
	}

}
