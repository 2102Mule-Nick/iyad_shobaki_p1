package com.revature.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.Hotel;

@Component
public class HotelRowMapper implements RowMapper<Hotel> {

	private HotelExtractor hotelExtractor;
	
	@Autowired
	public void setHotelExtractor(HotelExtractor hotelExtractor) {
		this.hotelExtractor = hotelExtractor;
	}

	@Override
	public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
		return hotelExtractor.extractData(rs);
	}

}
