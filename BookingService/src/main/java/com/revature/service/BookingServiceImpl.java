package com.revature.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BookingDao;
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


	@Override
	public boolean bookRoom(Booking booking) {
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
	public List<Integer> getAllAvailableRoomsByHotelAndType(int hotelId, int roomType, LocalDate checkInDate) {
		RoomWSImplService roomWSImplService = new RoomWSImplService();
		RoomWS roomPort = roomWSImplService.getRoomWSImplPort();
		
		List<Integer> allRoomNumbers = roomPort.getAllRoomsByHotelAndType(hotelId, roomType);
		
		List<Booking> allBookedRoomsByHotel = bookingDao.getAllBookedRoomsByHotel(hotelId);
		List<Integer> bookRoomsIds = new ArrayList<>();
		
		for(Booking booking : allBookedRoomsByHotel) {
			if(checkInDate.isEqual(booking.getCheckIn()) || (checkInDate.isAfter(booking.getCheckIn()) && checkInDate.isBefore(booking.getCheckOut()))){
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
