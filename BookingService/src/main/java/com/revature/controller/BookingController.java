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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.UserPaymentInfo;
import com.revature.exception.PaymentDisapproved;
import com.revature.pojo.Booking;
import com.revature.pojo.Payment;
import com.revature.pojo.User;
import com.revature.service.BookingService;
import com.revature.service.UserServiceFinder;
import com.revature.ws.Hotel;
import com.revature.ws.RoomType;

@RestController
public class BookingController {

	private BookingService bookingService;

	private UserServiceFinder userServiceFinder;

	@Autowired
	public void setUserServiceFinder(UserServiceFinder userServiceFinder) {
		this.userServiceFinder = userServiceFinder;
	}

	@Autowired
	public void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@PostMapping("/booking")
	public ResponseEntity<String> bookRoom(@RequestBody Booking booking) {

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate checkIn = LocalDate.parse(booking.getCheckInString(), dateFormatter);
		LocalDate checkOut = LocalDate.parse(booking.getCheckOutString(), dateFormatter);
		booking.setCheckIn(checkIn);
		booking.setCheckOut(checkOut);

		try {
			if (bookingService.bookRoom(booking)) {
				return ResponseEntity.ok("Room booked successfully!");
			}
		} catch (PaymentDisapproved e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.badRequest().body("Something went wrong. Please try later!");
	}

	@GetMapping("/booking/hotels")
	public List<Hotel> GetAllHotels() {
		return bookingService.getAllHotels();
	}

	@GetMapping("/booking/hotels/{state}")
	public List<Hotel> getAllHotelsByState(@PathVariable String state) {
		return bookingService.getAllHotelsByState(state);
	}

	@GetMapping("/booking/roomtypes")
	public List<RoomType> getAllRoomTypes() {
		return bookingService.getAllRoomTypes();
	}

	@GetMapping("/booking/{hotelId}/{roomType}/{checkInDate}/{checkOutDate}")
	public List<Integer> getAllAvailableRooms(@PathVariable int hotelId, @PathVariable int roomType,
			@PathVariable String checkInDate, @PathVariable String checkOutDate) {

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate checkIn = LocalDate.parse(checkInDate, dateFormatter);
		LocalDate checkOut = LocalDate.parse(checkOutDate, dateFormatter);

		return bookingService.getAllAvailableRoomsByHotelAndType(hotelId, roomType, checkIn, checkOut);

	}

	@GetMapping("/booking/userInfo")
	public ResponseEntity<UserPaymentInfo> getUserInfoByEmailAndPassword(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {
		return userServiceFinder.getUserInfo(username, password);
	}
	
	@PostMapping("/booking/registerUser")
	public ResponseEntity<String> registerNewUser(@RequestBody User user){
		return userServiceFinder.registerNewUser(user);
	}
	
	@PostMapping("/booking/addPayment")
	public ResponseEntity<String> addUserPaymentInfo(@RequestBody Payment payment){
		return userServiceFinder.addPaymentInfo(payment);
	}

}
