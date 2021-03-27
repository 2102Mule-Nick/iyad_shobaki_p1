package com.revature.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pojo.Hotel;
import com.revature.service.HotelService;

//@WebService(endpointInterface = "com.revature.ws.HotelWS",
//serviceName = "hotelService") 
@Service
public class HotelWSImpl implements HotelWS {

	private HotelService hotelService;

	@Autowired
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}

	@Override
	public List<Hotel> getAllHotelsByState(String state) {
		return hotelService.getAllHotelsByState(state);
	}

}
