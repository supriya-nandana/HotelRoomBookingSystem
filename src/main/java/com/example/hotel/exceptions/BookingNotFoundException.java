package com.example.hotel.exceptions;

public class BookingNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BookingNotFoundException(String mesage) {
		super(mesage);
	}

}
