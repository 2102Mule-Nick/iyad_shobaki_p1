package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.RoomDao;
import com.revature.pojo.RoomType;

@WebService(endpointInterface = "com.revature.service.RoomService",
serviceName = "roomService")
public class RoomServiceImpl implements RoomService {

	private RoomDao roomDao;
	
	@Autowired
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public List<RoomType> getAllRoomTypes() {
		return roomDao.getAllRoomTypes();
	}

	@Override
	public List<String> getAllRoomsByHotelAndType(int hotelId, int roomType) {
		return roomDao.getAllRoomsByHotelAndType(hotelId, roomType);
	}

}
