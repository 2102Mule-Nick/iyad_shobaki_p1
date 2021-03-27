package com.revature.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.revature.pojo.Hotel;

@WebService
public interface HotelWS {

	@WebMethod
	List<Hotel> getAllHotels();
	
	@WebMethod
	List<Hotel> getAllHotelsByState(String state);
}
