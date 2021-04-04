package com.revature.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.Booking;

@Component
public class BookingRowMapper implements RowMapper<Booking> {

	private BookingExtractor bookingExtractor;
	
	@Autowired
	public void setBookingExtractor(BookingExtractor bookingExtractor) {
		this.bookingExtractor = bookingExtractor;
	}


	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
		return bookingExtractor.extractData(rs);
	}

}
