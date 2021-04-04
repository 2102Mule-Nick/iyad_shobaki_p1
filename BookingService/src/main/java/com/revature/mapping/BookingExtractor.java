package com.revature.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.revature.pojo.Booking;

@Component
public class BookingExtractor implements ResultSetExtractor<Booking> {

	@Override
	public Booking extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		java.sql.Date checkInDate = rs.getDate("check_in");
		java.sql.Date checkOutDate = rs.getDate("check_out");
		
		LocalDate checkIn = checkInDate.toLocalDate();
		LocalDate checkOut = checkOutDate.toLocalDate();
		
		Booking newBooking = new Booking();
		newBooking.setBookingId(rs.getInt("booking_id"));
		newBooking.setHotelId(rs.getInt("hotel_id"));
		newBooking.setRoomId(rs.getInt("room_id"));
		newBooking.setUserId(rs.getInt("user_id"));
		newBooking.setCheckIn(checkIn);
		newBooking.setCheckOut(checkOut);
		newBooking.setStatus(rs.getInt("status_id"));
		
		return newBooking;
	}

}
