package com.revature.driver;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.dao.BookingDao;
import com.revature.dao.BookingDaoImpl;
import com.revature.pojo.Booking;

public class Driver {

	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BookingDao bookingDao = applicationContext.getBean("bookingDaoImpl", BookingDaoImpl.class);

		Booking booking = new Booking(2,2,2,LocalDate.now().plusDays(1), LocalDate.now().plusDays(2),
				1);
		
		System.out.println(bookingDao.bookRoom(booking));
			
//		HotelWSImplService hotelWSImplService = new HotelWSImplService();
//		HotelWS hotelWS = hotelWSImplService.getHotelWSImplPort();
//		
//		List<Hotel> hotelListByState =  hotelWS.getAllHotelsByState("Ohio");
//		for(Hotel hotel : hotelListByState) {
//			System.out.println(hotel.getName());
//		}
		
//		UserServiceFinder finder = new UserServiceFinder();
//		UserPaymentInfo paymentInfo = finder.getUserInfo("iyad@shobaki.com", "1234").getBody();
//		
//		System.out.println(paymentInfo);
		
//		User user = new User("Name", "Family",  "(342) 6578899", "name@family.com","1234");
//		
//		String result = finder.registerNewUser(user).getBody();
//		System.out.println(result);
		
//		Payment payment = new Payment("Test", "1234567890123456", "233", 61);
//		System.out.println(finder.addPaymentInfo(payment).getBody());
		
	}

}
