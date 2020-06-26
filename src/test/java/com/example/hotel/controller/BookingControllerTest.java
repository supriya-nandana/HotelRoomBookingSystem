package com.example.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.hotel.dto.BookRequestDto;
import com.example.hotel.dto.BookResponseDto;
import com.example.hotel.model.Guests;
import com.example.hotel.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

	
	@Mock
	BookService bookService;
	@InjectMocks
	BookingController bookingController;
	MockMvc mockMvc;
	
	ObjectMapper objectMapper;
	
	BookRequestDto bookRequestDto;
	BookResponseDto bookResponseDto;
	
	
	Guests guests;
	public void setUp()
	{
		objectMapper=new ObjectMapper();
		mockMvc=MockMvcBuilders.standaloneSetup(bookingController).build();
	
		bookRequestDto=new BookRequestDto();
		bookRequestDto.setUserId(1);
		bookRequestDto.setRoomId(1);
		bookRequestDto.setNoOfGuests(2);
	   
		  guests = new Guests();
		guests.setGuestName("sai");
		guests.setGuestAge(23);
		guests.setGuestGender("female");
		guests.setGuestPhoneNumber("9876567889");
		List<Guests> guest=new ArrayList<>();
		guest.add(guests);
	}
	
	@Test
	public void bookRoom() {
		BookResponseDto bookres=new BookResponseDto();
		bookres.setTotalPrice(3000.00);
		/*
		when(bookService.getBookingdetails(any(BookRequestDto.class))).thenReturns(bookres);
	//	mockMvc.perform(post("/bookroom")).content
		mockMvc.perform(post("/bookroom").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(bookRequestDto)))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
		      verify(bookService).getBookingdetails(any(BookRequestDto.class));
		    
		*/
		
	}
	
}
