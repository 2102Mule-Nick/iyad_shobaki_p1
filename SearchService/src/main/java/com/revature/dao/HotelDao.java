package com.revature.dao;

import java.util.List;

import com.revature.pojo.Hotel;

public interface HotelDao {
	
	List<Hotel> getAllHotels();
	List<Hotel> getAllHotelsByState(String state);
}
