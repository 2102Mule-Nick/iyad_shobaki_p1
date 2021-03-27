package com.revature.service;

import java.util.List;


import com.revature.pojo.Hotel;

public interface HotelService {
	
	List<Hotel> getAllHotels();
	
	List<Hotel> getAllHotelsByState(String state);
}
