package com.revature.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.pojo.RoomType;

@WebService
public interface RoomWS {

	@WebMethod
	List<RoomType> getAllRoomTypes();

	@WebMethod
	List<Integer> getAllRoomsByHotelAndType(int hotelId, int roomType);
}
