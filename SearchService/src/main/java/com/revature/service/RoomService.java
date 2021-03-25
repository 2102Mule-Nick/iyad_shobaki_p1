package com.revature.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.pojo.RoomType;

@WebService
public interface RoomService {

	@WebMethod
	List<RoomType> getAllRoomTypes();
	
	@WebMethod
	List<String> getAllRoomsByHotelAndType(int hotelId, int roomType);
}
