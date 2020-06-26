package com.example.hotel.service;

import com.example.hotel.dto.BookRequestDto;
import com.example.hotel.dto.BookResponseDto;
import com.example.hotel.exceptions.BookingNotFoundException;
import com.example.hotel.exceptions.DayLimitException;

public interface BookService {

	BookResponseDto getBookingdetails(BookRequestDto bookRequestDto) throws BookingNotFoundException, DayLimitException;

}
