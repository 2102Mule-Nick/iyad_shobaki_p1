package com.revature.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class RoomNumberRowMapper implements RowMapper<String> {

	private RoomNumberExtractor roomNumberExtractor;
	
	@Autowired
	public void setRoomNumberExtractor(RoomNumberExtractor roomNumberExtractor) {
		this.roomNumberExtractor = roomNumberExtractor;
	}


	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		return roomNumberExtractor.extractData(rs);
	}

}
