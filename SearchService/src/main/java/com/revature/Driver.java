package com.revature;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.pojo.Hotel;
import com.revature.service.HotelService;
import com.revature.service.HotelServiceImpl;


public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		HotelService hotelService = applicationContext.getBean("hotelServiceImpl", HotelServiceImpl.class);
		
		List<Hotel> hotelList = hotelService.getAllHotels();
		System.out.println(hotelList);
	}

}
