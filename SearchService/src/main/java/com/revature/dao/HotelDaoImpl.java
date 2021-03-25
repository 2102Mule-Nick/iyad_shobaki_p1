package com.revature.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.mapper.HotelRowMapper;
import com.revature.pojo.Hotel;

@Repository
public class HotelDaoImpl implements HotelDao {

	private JdbcTemplate jdbcTemplate;

	private HotelRowMapper hotelRowMapper;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setHotelRowMapper(HotelRowMapper hotelRowMapper) {
		this.hotelRowMapper = hotelRowMapper;
	}

	@Override
	public List<Hotel> getAllHotels() {

		String sql = "select * from hotel";

		List<Hotel> hotelList = jdbcTemplate.query(sql, hotelRowMapper);

		return hotelList;
	}

	@Override
	public List<Hotel> getAllHotelsByState(String state) {
		
		String sql = "select * from hotel where state = ?";

		List<Hotel> hotelList = jdbcTemplate.query(sql, hotelRowMapper, state);

		return hotelList;
	}

}
