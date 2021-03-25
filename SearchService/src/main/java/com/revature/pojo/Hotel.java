package com.revature.pojo;

public class Hotel {

	private int hotelId;
	private String name;
	private String email;
	private String state;
	private String city;
	private String street;

	
	public Hotel() {
		super();
	}

	public Hotel(int hotelId, String name, String email, String state, String city, String street) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.email = email;
		this.state = state;
		this.city = city;
		this.street = street;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", email=" + email + ", state=" + state + ", city=" + city + ", street=" + street
				+ "]";
	}

}
