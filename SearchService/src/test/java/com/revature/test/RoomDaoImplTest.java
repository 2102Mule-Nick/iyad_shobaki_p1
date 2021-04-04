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

import com.revature.dao.RoomDaoImpl;
import com.revature.mapper.RoomNumberRowMapper;
import com.revature.mapper.RoomTypeRowMapper;
import com.revature.pojo.Hotel;
import com.revature.pojo.RoomType;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfig.class })
class RoomDaoImplTest {
	
	@Autowired
	JdbcTemplate mockJdbcTemplate;
	@Autowired
	RoomDaoImpl roomDaoImpl;
	@Autowired
	RoomNumberRowMapper roomNumberRowMapper;
	@Autowired
	RoomTypeRowMapper roomTypeRowMapper;

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
	void testGetAllRoomTypes() {
		
		String sql = "select * from room_type";

		List<RoomType> roomTypes = new ArrayList<>();

		RoomType roomType = new RoomType(1, "Single Room", 350.00f);
		
		roomTypes.add(roomType);

		when(mockJdbcTemplate.query(sql, roomTypeRowMapper)).thenReturn(roomTypes);
		
		List<RoomType> roomTypesReturn = roomDaoImpl.getAllRoomTypes();
		
		verify(mockJdbcTemplate).query(sql, roomTypeRowMapper);
		
		assertFalse(roomTypesReturn.isEmpty());
	}

	@Test
	void testGetAllRoomsByHotelAndType() {
		
		String sql = "select * from room where hotel_id = ? and room_type_id = ?";
		
		int hotelId = 1;
		int roomType = 2;
		
		List<Integer> roomNumbers  = new ArrayList<>();
		
		roomNumbers.add(1);
		roomNumbers.add(2);

		//when(mockJdbcTemplate.query(sql, roomNumberRowMapper, hotelId, roomType)).thenReturn(roomNumbers);
		
		List<Integer> roomNumbersReturn = roomDaoImpl.getAllRoomsByHotelAndType(hotelId, roomType);
		
		verify(mockJdbcTemplate).query(sql, roomNumberRowMapper, hotelId, roomType);
		
		//assertFalse(roomNumbersReturn.isEmpty());
		assertEquals(2, roomNumbersReturn.size());
		
	}

}
