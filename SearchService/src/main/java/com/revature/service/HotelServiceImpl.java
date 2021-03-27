package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.HotelDao;
import com.revature.pojo.Hotel;


@Service
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
