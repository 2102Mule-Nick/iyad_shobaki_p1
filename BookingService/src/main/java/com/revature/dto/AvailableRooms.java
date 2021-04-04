package com.revature.dto;

public class AvailableRooms {

	private int hotelId;
	private int roomType;
	private String checkInDate;
	
	public AvailableRooms(int hotelId, int roomType, String checkInDate) {
		super();
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.checkInDate = checkInDate;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	
	
}
