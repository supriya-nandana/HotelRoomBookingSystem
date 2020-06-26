package com.example.hotel.exceptions;

public class DayLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DayLimitException(String message)
	{
		super(message);
	}
}
