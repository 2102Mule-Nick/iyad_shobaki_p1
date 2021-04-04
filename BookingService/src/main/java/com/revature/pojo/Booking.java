package com.revature.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Booking {

	private int bookingId;
	private int hotelId;
	private int roomId;
	private int userId;
	private String checkInString;
	private LocalDate checkIn;
	private String checkOutString;
	private LocalDate checkOut;
	private int status;
	
	public Booking() {
		super();
	}

	
//	@JsonCreator
//	public Booking(int hotelId, int roomId, int userId, 
//			@JsonFormat(pattern = "MM/dd/yyyy") LocalDate checkIn, 
//			@JsonFormat(pattern = "MM/dd/yyyy")	LocalDate checkOut, int status) {

	public Booking(int hotelId, int roomId, int userId, 
			LocalDate checkIn, 
			LocalDate checkOut, int status) {
		super();
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
	}


	public Booking(int bookingId, int hotelId, int roomId, int userId, LocalDate checkIn, LocalDate checkOut,
			int status) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.status = status;
	}

	

	public String getCheckInString() {
		return checkInString;
	}


	public void setCheckInString(String checkInString) {
		this.checkInString = checkInString;
	}


	public String getCheckOutString() {
		return checkOutString;
	}


	public void setCheckOutString(String checkOutString) {
		this.checkOutString = checkOutString;
	}


	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public LocalDate getCheckIn() {
		return checkIn;
	}


	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}


	public LocalDate getCheckOut() {
		return checkOut;
	}


	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", hotelId=" + hotelId + ", roomId=" + roomId + ", userId=" + userId
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", status=" + status + "]";
	}
	
	
	
}
