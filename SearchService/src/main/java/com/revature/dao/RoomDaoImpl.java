package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.mapper.RoomNumberRowMapper;
import com.revature.mapper.RoomTypeRowMapper;
import com.revature.pojo.RoomType;

@Repository
public class RoomDaoImpl implements RoomDao {

	private JdbcTemplate jdbcTemplate;
	private RoomNumberRowMapper roomNumberRowMapper;
	private RoomTypeRowMapper roomTypeRowMapper;

	@Autowired
	public void setRoomTypeRowMapper(RoomTypeRowMapper roomTypeRowMapper) {
		this.roomTypeRowMapper = roomTypeRowMapper;
	}

	@Autowired
	public void setRoomNumberRowMapper(RoomNumberRowMapper roomNumberRowMapper) {
		this.roomNumberRowMapper = roomNumberRowMapper;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<RoomType> getAllRoomTypes() {

		String sql = "select * from room_type";

		List<RoomType> roomTypes = jdbcTemplate.query(sql, roomTypeRowMapper);

		return roomTypes;
	}

//	@Override
//	public List<String> getAllRoomsByHotelAndType(int hotelId, int roomType) {
//
//		String sql = "select * from room where hotel_id = ? and room_type_id = ?";
//
//		List<String> roomsNumbers = jdbcTemplate.query(sql, roomNumberRowMapper, hotelId, roomType);
//
//		return roomsNumbers;
//
//	}
//	
	@Override
	public List<Integer> getAllRoomsByHotelAndType(int hotelId, int roomType) {

		String sql = "select * from room where hotel_id = ? and room_type_id = ?";

		List<Integer> roomsNumbers = jdbcTemplate.query(sql, (rs,row) -> rs.getInt("room_id"), hotelId, roomType);

		return roomsNumbers;

	}

}
