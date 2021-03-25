package com.revature.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.RoomType;

@Component
public class RoomTypeRowMapper implements RowMapper<RoomType> {

	private RoomTypeExtractor roomTypeExtractor;
	
	@Autowired
	public void setRoomTypeExtractor(RoomTypeExtractor roomTypeExtractor) {
		this.roomTypeExtractor = roomTypeExtractor;
	}


	@Override
	public RoomType mapRow(ResultSet rs, int rowNum) throws SQLException {
		return roomTypeExtractor.extractData(rs);
	}

}
