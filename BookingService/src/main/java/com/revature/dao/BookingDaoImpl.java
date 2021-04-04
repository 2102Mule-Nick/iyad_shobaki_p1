package com.revature.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.revature.mapping.BookingRowMapper;
import com.revature.pojo.Booking;

@Repository
public class BookingDaoImpl implements BookingDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private BookingRowMapper bookingRowMapper;
	
	@Autowired
	public void setBookingRowMapper(BookingRowMapper bookingRowMapper) {
		this.bookingRowMapper = bookingRowMapper;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean bookRoom(Booking booking) {
		String sql = "insert into booking (hotel_id, room_id, user_id, check_in, check_out, status_id)"
				+ " values (?,?,?,?, ?, ?)";
		
		Object[] args = new Object[] {booking.getHotelId(), booking.getRoomId(),
				booking.getUserId(), booking.getCheckIn(), booking.getCheckOut(), booking.getStatus()};
		
		if(jdbcTemplate.update(sql,args) == 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<Booking> getAllBookedRoomsByHotel(int hotelId) {
		
		String sql = "select * from booking b where hotel_id = ? and (check_in >= current_date or check_out >= current_date)";
		
		
		List<Booking> allBookedRoomsByHotel = jdbcTemplate.query(sql, bookingRowMapper, hotelId);
//		List<Integer> roomIds = jdbcTemplate.query(sql,	(rs,row) -> rs.getInt("room_id"), hotelId);
		
//		List<String> roomNumbers = new ArrayList<>(roomIds.size());
//		
// 		for(Integer i : roomIds) {
// 			roomNumbers.add(String.valueOf(i));
// 		}
		return allBookedRoomsByHotel;
	}

}
