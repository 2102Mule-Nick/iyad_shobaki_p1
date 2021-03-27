package com.revature.pojo;

public class Payment {
	
	private int paymentId;
	private String creditCardType;
	private String creditCardNumber;
	private String securityCode;
	private int userId;
	
	public Payment() {
		super();
	}

	public Payment(int paymentId, String creditCardType, String creditCardNumber, String securityCode, int userId) {
		super();
		this.paymentId = paymentId;
		this.creditCardType = creditCardType;
		this.creditCardNumber = creditCardNumber;
		this.securityCode = securityCode;
		this.userId = userId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Payment [creditCardType=" + creditCardType + ", creditCardNumber=" + creditCardNumber
				+ ", securityCode=" + securityCode + "]";
	}

	
	
	
}