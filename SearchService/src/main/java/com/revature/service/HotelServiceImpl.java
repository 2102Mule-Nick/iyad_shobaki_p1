package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.HotelDao;
import com.revature.pojo.Hotel;

@WebService(endpointInterface = "com.revature.service.HotelService",
serviceName = "hotelService")
public class HotelServiceImpl implements HotelService {

	private HotelDao hotelDao;
	
	@Autowired
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelDao.getAllHotels();
	}

	@Override
	public List<Hotel> getAllHotelsByState(String state) {
		return hotelDao.getAllHotelsByState(state);
	}

}
