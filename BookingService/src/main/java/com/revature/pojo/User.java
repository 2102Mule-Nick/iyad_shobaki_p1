package com.revature.pojo;

public class User {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailAddress;
	private String password;

	// Default constructor
	public User() {
		super();
	}

	// Constructor with parameters
	public User(String firstName, String lastName, String phoneNumber, String emailAddress, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	// Constructor with parameters
	public User(int userId, String firstName, String lastName, String phoneNumber, String emailAddress,
			String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	// Setters and getters
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + "]";
	}
	


}
