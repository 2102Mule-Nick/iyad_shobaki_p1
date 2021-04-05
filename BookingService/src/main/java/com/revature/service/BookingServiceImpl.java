package com.revature.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.BookingDao;
import com.revature.exception.PaymentDisapproved;
//import com.revature.messaging.JmsMessageListener;
//import com.revature.messaging.JmsMessageSender;
import com.revature.pojo.Booking;
import com.revature.ws.Hotel;
import com.revature.ws.HotelWS;
import com.revature.ws.HotelWSImplService;
import com.revature.ws.RoomType;
import com.revature.ws.RoomWS;
import com.revature.ws.RoomWSImplService;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingDao bookingDao;
	
	@Autowired
	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}

	public static String paymentStatus;
	
	@Override
	@Transactional
	public boolean bookRoom(Booking booking) throws PaymentDisapproved {
		
		//Receive Jms message with user payment info to PaymentService 
		String result = paymentStatus;
		System.out.println(result);
		if(!result.equals("Approved")) {
			throw new PaymentDisapproved("Payment method not valid!");
		}
		
		return bookingDao.bookRoom(booking);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		HotelWSImplService hotelWSImplService = new HotelWSImplService();
		HotelWS hotelWS = hotelWSImplService.getHotelWSImplPort();
		List<Hotel> hotelList =  hotelWS.getAllHotels();
		
		return hotelList;
	}

	@Override
	public List<Hotel> getAllHotelsByState(String state) {
		
		HotelWSImplService hotelWSImplService = new HotelWSImplService();
		HotelWS hotelPort = hotelWSImplService.getHotelWSImplPort();
		
		List<Hotel> hotelListByState =  hotelPort.getAllHotelsByState(state);
		return hotelListByState;
	}


	@Override
	public List<RoomType> getAllRoomTypes() {
		
		RoomWSImplService roomWSImplService = new RoomWSImplService();
		RoomWS roomPort = roomWSImplService.getRoomWSImplPort();
		
		List<RoomType> roomTypes = roomPort.getAllRoomTypes();
		
		return roomTypes;
	}


	@Override
	public List<Integer> getAllAvailableRoomsByHotelAndType(int hotelId, int roomType,
			LocalDate checkInDate, LocalDate checkOutDate) {
		RoomWSImplService roomWSImplService = new RoomWSImplService();
		RoomWS roomPort = roomWSImplService.getRoomWSImplPort();
		
		List<Integer> allRoomNumbers = roomPort.getAllRoomsByHotelAndType(hotelId, roomType);
		
		List<Booking> allBookedRoomsByHotel = bookingDao.getAllBookedRoomsByHotel(hotelId);
		List<Integer> bookRoomsIds = new ArrayList<>();
		
		Period period = Period.between(checkInDate, checkOutDate);
		//System.out.println(period.getDays());
		
		for(Booking booking : allBookedRoomsByHotel) {
			if(		((checkInDate.isEqual(booking.getCheckIn()) 
					|| (checkInDate.isAfter(booking.getCheckIn())
					&& checkInDate.isBefore(booking.getCheckOut()))))
					|| ((checkOutDate.isEqual(booking.getCheckIn()) 
					|| (checkOutDate.isAfter(booking.getCheckIn())
					&& checkOutDate.isBefore(booking.getCheckOut())))) 
					|| ((checkInDate.plusDays(period.getDays()/2).isEqual(booking.getCheckIn()) 
					|| (checkInDate.plusDays(period.getDays()/2).isAfter(booking.getCheckIn())
					&& checkInDate.plusDays(period.getDays()/2).isBefore(booking.getCheckOut())))) ){
				
				bookRoomsIds.add(booking.getRoomId());
			}
		}
		
		List<Integer> availableRoomsNumbers = new ArrayList<>();
		for(Integer i : allRoomNumbers) {
			if(bookRoomsIds.contains(i)) {
				continue;
			}else {
				
				availableRoomsNumbers.add(i);
			}
		}
		
		return availableRoomsNumbers;
	}

}
