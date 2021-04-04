package com.revature.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.AvailableRooms;
import com.revature.pojo.Booking;
import com.revature.service.BookingService;
import com.revature.ws.Hotel;
import com.revature.ws.RoomType;

@RestController
public class BookingController {

	private BookingService bookingService;

	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@PostMapping("/booking")
	public ResponseEntity<String> bookRoom(@RequestBody Booking booking){
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate checkIn = LocalDate.parse(booking.getCheckInString(), dateFormatter);
		LocalDate checkOut = LocalDate.parse(booking.getCheckOutString(), dateFormatter);
		booking.setCheckIn(checkIn);
		booking.setCheckOut(checkOut);
		
		if(bookingService.bookRoom(booking)) {
			return ResponseEntity.ok("Room booked successfully!");
		}
		return ResponseEntity.badRequest().body("Something went wrong. Please try later!");
	}
	
	@GetMapping("/booking/hotels")
	public List<Hotel> GetAllHotels(){
		return bookingService.getAllHotels();
	}
	
	@GetMapping("/booking/hotels/{state}")
	public List<Hotel> getAllHotelsByState(@PathVariable String state){
		return bookingService.getAllHotelsByState(state);
	}
	
	@GetMapping("/booking/roomtypes")
	public List<RoomType> getAllRoomTypes(){
		return bookingService.getAllRoomTypes();
	}
	
	@GetMapping("/booking/{hotelId}/{roomType}/{checkInDate}")
	public List<Integer> getAllAvailableRooms(@PathVariable int hotelId,
			@PathVariable int roomType, @PathVariable String checkInDate){
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate checkIn = LocalDate.parse(checkInDate, dateFormatter);
		
		return bookingService.getAllAvailableRoomsByHotelAndType(hotelId,
				roomType, checkIn);
		
		
	}
	
	
	
}
