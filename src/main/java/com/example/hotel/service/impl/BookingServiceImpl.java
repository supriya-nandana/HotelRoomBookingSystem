package com.example.hotel.service.impl;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.BookDao;
import com.example.hotel.dao.HotelDao;
import com.example.hotel.dao.RoomDao;
import com.example.hotel.dto.BookRequestDto;
import com.example.hotel.dto.BookResponseDto;
import com.example.hotel.dto.Dto;
import com.example.hotel.exceptions.BookingNotFoundException;
import com.example.hotel.exceptions.DayLimitException;
import com.example.hotel.helper.RoomHelper;
import com.example.hotel.model.Booking;
import com.example.hotel.service.BookService;

@Service
public class BookingServiceImpl implements BookService{

	private static Log logger=LogFactory.getLog(BookingServiceImpl.class);

	@Autowired
	BookDao bookDao;
	@Autowired
	RoomDao roomDao;
	@Autowired
	HotelDao hotelDao;
	
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public BookResponseDto getBookingdetails(BookRequestDto bookRequestDto) throws BookingNotFoundException, DayLimitException {
		logger.info("executing the bookingdetails and returns the details of the bookings");
		Booking book=new Booking();
		BeanUtils.copyProperties(bookRequestDto, book);
		book.getGuests().addAll(bookRequestDto.getGuest());
		book.setBookingTime(LocalDateTime.now());
		book.setRoomNumber(RoomHelper.getRoomNumber());		
	
		double diff=(((bookRequestDto.getCheckOut().getDayOfMonth())-(bookRequestDto.getCheckIn().getDayOfMonth()))+1);
		if(diff>=10) {
			throw new DayLimitException("hotel room limit is below 10 days only..");
		}
		book.setTotalPrice(roomDao.findPriceByRoomId(bookRequestDto.getRoomId())*diff);
		Booking bookings=bookDao.save(book);
		BookResponseDto bookresponsedto=new BookResponseDto();
		 BeanUtils.copyProperties(bookings, bookresponsedto);		
		 bookresponsedto.setRoomType(roomDao.findRoomTypeByRoomId(bookRequestDto.getRoomId()));		 
		Dto dto=new Dto(); 
		 dto.setHotelId(roomDao.findHotelIdByRoomId(bookRequestDto.getRoomId()));
		 bookresponsedto.setHotelName(hotelDao.findHotelNameByHotelId(dto.getHotelId()));
		 
		return bookresponsedto;
	 
		 
	}
}

	

