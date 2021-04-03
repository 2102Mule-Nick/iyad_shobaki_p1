package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.ws.Hotel;
import com.revature.ws.HotelWS;
import com.revature.ws.HotelWSImplService;
import com.revature.ws.RoomType;
import com.revature.ws.RoomWS;
import com.revature.ws.RoomWSImplService;

@Service
public class SearchServiceImpl implements SearchService {

	HotelWSImplService hotelWSImplService = new HotelWSImplService();
	HotelWS hotelWS = hotelWSImplService.getHotelWSImplPort();
	
	RoomWSImplService roomWSImplService = new RoomWSImplService();
	RoomWS roomWS = roomWSImplService.getRoomWSImplPort();
	
	@Override
	public List<Hotel> getAllHotels() {
		
		List<Hotel> hotelList =  hotelWS.getAllHotels();
		
		return hotelList;
	}

	@Override
	public List<Hotel> getAllHotelsByState(String state) {
		
		List<Hotel> hotelListByState =  hotelWS.getAllHotelsByState("Ohio");
		
		return hotelListByState;
	}

	@Override
	public List<RoomType> getAllRoomTypes() {
		
		List<RoomType> roomTypes = roomWS.getAllRoomTypes();
		
		return roomTypes;
	}

	@Override
	public List<String> getAllRoomsByHotelAndType(int hotelId, int roomType) {
		
		List<String> roomListByHotelIdAndTypeCategory = roomWS.getAllRoomsByHotelAndType(hotelId, roomType);
		
		return roomListByHotelIdAndTypeCategory;
	}

}
