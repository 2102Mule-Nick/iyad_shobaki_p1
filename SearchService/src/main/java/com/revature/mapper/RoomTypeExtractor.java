package com.revature.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.RoomType;

@Component
public class RoomTypeExtractor implements ResultSetExtractor<RoomType> {

	@Override
	public RoomType extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		RoomType roomType = new RoomType(rs.getInt("room_type_id"),
				rs.getString("roome_type"), rs.getFloat("price_per_night"));
		
		return roomType;
	}

}
