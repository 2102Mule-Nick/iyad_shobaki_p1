package com.revature.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Hotel;

@Component
public class HotelExtractor implements ResultSetExtractor<Hotel> {

	@Override
	public Hotel extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Hotel newHotel = new Hotel(rs.getInt("hotel_id"),
				rs.getString("hotel_name"), rs.getString("email_address"),
				rs.getString("state"), rs.getString("city"), rs.getString("street"));
		
		
		return newHotel;
	}

}
