package com.example.hotel.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.dto.HotelsResponseDto;
import com.example.hotel.exceptions.HotelsNotFoundException;
import com.example.hotel.service.HotelService;

@RestController
public class HotelController {

	private static Log logger = LogFactory.getLog(HotelController.class);
	@Autowired
	HotelService hotelService;
	
	/**
	 * @param hotelLocation
	 * @return
	 * @throws HotelsNotFoundException
	 */
	@GetMapping("/hotels/hotelLocation")
	public List<HotelsResponseDto> searchHotelsByLocation(@RequestParam("hotelLocation")String hotelLocation) throws HotelsNotFoundException {
		logger.info("executing the searchHotelsByLocation in HotelController");
		return hotelService.getHotelsByLocation(hotelLocation);
	}
	
	/**
	 * @param exception
	 * @return responseEntity
	 */
	@ExceptionHandler(HotelsNotFoundException.class)
	public ResponseEntity<String> exceptionhandler(HotelsNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}
