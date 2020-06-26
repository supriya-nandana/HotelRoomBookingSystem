package com.example.hotel.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.dto.BookRequestDto;
import com.example.hotel.dto.BookResponseDto;
import com.example.hotel.exceptions.BookingNotFoundException;
import com.example.hotel.exceptions.DayLimitException;
import com.example.hotel.service.BookService;

@RestController
public class BookingController {

	private static Log logger = LogFactory.getLog(BookingController.class);
	@Autowired
	BookService bookService;
	
	/**
	 * @param bookRequestDto
	 * @return getbookingDetails
	 * @throws BookingNotFoundException
	 * @throws DayLimitException
	 */
	@PostMapping("/bookroom")
	public BookResponseDto bookRoom(@RequestBody BookRequestDto bookRequestDto) throws BookingNotFoundException, DayLimitException  {
		logger.info("booking room based on userid and roomid in bookingcontroller");
		return bookService.getBookingdetails(bookRequestDto);
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<String> exceptionhandler(BookingNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DayLimitException.class)
	public ResponseEntity<String> exceptionhandler(DayLimitException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
