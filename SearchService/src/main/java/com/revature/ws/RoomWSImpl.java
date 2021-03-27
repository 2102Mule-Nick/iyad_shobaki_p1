package com.revature.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.RoomType;
import com.revature.service.RoomService;

//@WebService(endpointInterface = "com.revature.ws.RoomWS",
//serviceName = "roomService")
@Service
public class RoomWSImpl implements RoomWS {

	private RoomService roomService;

	@Autowired
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	@Override
	public List<RoomType> getAllRoomTypes() {
		return roomService.getAllRoomTypes();
	}

	@Override
	public List<String> getAllRoomsByHotelAndType(int hotelId, int roomType) {
		return roomService.getAllRoomsByHotelAndType(hotelId, roomType);
	}

}
