package com.revature.exception;

public class PaymentDisapproved extends Exception {

	public PaymentDisapproved() {
		super();
	}

	public PaymentDisapproved(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PaymentDisapproved(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentDisapproved(String message) {
		super(message);
	}

	public PaymentDisapproved(Throwable cause) {
		super(cause);
	}

	
	
}
