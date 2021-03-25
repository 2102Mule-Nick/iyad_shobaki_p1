package com.revature.pojo;

public class RoomType {
	
	private int roomTypeId;
	private String roomType;
	private float pricePerNight;
	
	public RoomType() {
		super();
	}

	public RoomType(int roomTypeId, String roomType, float pricePerNight) {
		super();
		this.roomTypeId = roomTypeId;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(float pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	@Override
	public String toString() {
		return "Room_Type [roomType=" + roomType + ", pricePerNight=" + pricePerNight + "]";
	}
	
	
	
}
