package com.revature.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.pojo.Hotel;

@WebService
public interface HotelService {
	
	@WebMethod
	List<Hotel> getAllHotels();
	
	@WebMethod
	List<Hotel> getAllHotelsByState(String state);
}
