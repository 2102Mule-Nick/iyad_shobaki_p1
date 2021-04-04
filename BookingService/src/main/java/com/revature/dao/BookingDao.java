package com.revature.dao;


import java.util.List;

import com.revature.pojo.Booking;

public interface BookingDao {

	public boolean bookRoom(Booking booking);
	
	public List<Booking> getAllBookedRoomsByHotel(int hotelId);
	
}
