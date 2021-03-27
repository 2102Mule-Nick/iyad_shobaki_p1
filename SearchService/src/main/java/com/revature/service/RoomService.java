package com.revature.service;

import java.util.List;


import com.revature.pojo.RoomType;

public interface RoomService {

	List<RoomType> getAllRoomTypes();
	
	List<String> getAllRoomsByHotelAndType(int hotelId, int roomType);
}
