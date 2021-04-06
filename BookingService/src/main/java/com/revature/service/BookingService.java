package com.revature.service;

import java.time.LocalDate;
import java.util.List;

import com.revature.exception.PaymentDisapproved;
import com.revature.pojo.Booking;
import com.revature.ws.Hotel;
import com.revature.ws.RoomType;

public interface BookingService {
	
	public void setPaymentApproval(String paymentApproval);
	
	public boolean bookRoom(Booking booking) throws PaymentDisapproved;
	
	public List<Hotel> getAllHotels();
	
	public List<Hotel> getAllHotelsByState(String state);
	
	public List<RoomType> getAllRoomTypes();
	
	public List<Integer> getAllAvailableRoomsByHotelAndType(int hotelId, int roomType, 
			LocalDate checkInDate, LocalDate checkOutDate);
	
}
