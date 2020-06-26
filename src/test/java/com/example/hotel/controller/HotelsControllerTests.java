package com.example.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.hotel.dto.HotelsResponseDto;
import com.example.hotel.exceptions.HotelsNotFoundException;
import com.example.hotel.service.HotelService;

@ExtendWith(MockitoExtension.class)
public class HotelsControllerTests {

	@Mock
	HotelService hotelService;
	
	@InjectMocks
	HotelController hotelsController;
	
	MockMvc mockMvc;
	
	HotelsResponseDto hotelResponseDto;
	
	@Test
	public void findHotelsByLocationTest() throws HotelsNotFoundException {
	List<HotelsResponseDto> hotels = new ArrayList<HotelsResponseDto>();

	Mockito.when(hotelService.getHotelsByLocation("chennai")).thenReturn(hotels);
			
	List<HotelsResponseDto> hotel = hotelsController.searchHotelsByLocation("chennai");
		Assertions.assertNotNull(hotel);
	
	}
	
	
}
