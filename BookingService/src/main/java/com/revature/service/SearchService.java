package com.revature.service;

import java.util.List;

import com.revature.ws.Hotel;
import com.revature.ws.RoomType;

public interface SearchService {

	List<Hotel> getAllHotels();
	
	List<Hotel> getAllHotelsByState(String state);
	
	List<RoomType> getAllRoomTypes();
	
	List<String> getAllRoomsByHotelAndType(int hotelId, int roomType);
}
