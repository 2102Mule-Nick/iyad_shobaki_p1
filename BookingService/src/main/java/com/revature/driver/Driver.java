package com.revature.driver;

import java.util.List;

import com.revature.dto.UserPaymentInfo;
import com.revature.pojo.Payment;
import com.revature.pojo.User;
import com.revature.service.UserServiceFinder;
import com.revature.ws.Hotel;
import com.revature.ws.HotelWS;
import com.revature.ws.HotelWSImplService;

public class Driver {

	public static void main(String[] args) {
//		
//		HotelWSImplService hotelWSImplService = new HotelWSImplService();
//		HotelWS hotelWS = hotelWSImplService.getHotelWSImplPort();
//		
//		List<Hotel> hotelListByState =  hotelWS.getAllHotelsByState("Ohio");
//		for(Hotel hotel : hotelListByState) {
//			System.out.println(hotel.getName());
//		}
		
		UserServiceFinder finder = new UserServiceFinder();
//		UserPaymentInfo paymentInfo = finder.getUserInfo("iyad@shobaki.com", "1234").getBody();
//		
//		System.out.println(paymentInfo);
		
//		User user = new User("Name", "Family",  "(342) 6578899", "name@family.com","1234");
//		
//		String result = finder.registerNewUser(user).getBody();
//		System.out.println(result);
		
		Payment payment = new Payment("Test", "1234567890123456", "233", 61);
		System.out.println(finder.addPaymentInfo(payment).getBody());
		
	}

}
