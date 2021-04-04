package com.revature.dao;

import java.util.List;

import com.revature.pojo.RoomType;

public interface RoomDao {
	
	List<RoomType> getAllRoomTypes();
	
	List<Integer> getAllRoomsByHotelAndType(int hotelId, int roomType);
	
}
