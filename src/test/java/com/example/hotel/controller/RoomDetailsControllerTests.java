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

import com.example.hotel.dto.RoomsResponseDto;
import com.example.hotel.exceptions.RoomNotFoundException;
import com.example.hotel.service.RoomService;

@ExtendWith(MockitoExtension.class)
public class RoomDetailsControllerTests {

	@Mock
	RoomService roomService;
	
	@InjectMocks
	RoomDetailsController roomDetailsController;
	
	MockMvc mockMvc;
	
	RoomsResponseDto roomsResponseDto;
	@Test
	public void getRoomByHotelId() throws RoomNotFoundException {
		
		List<RoomsResponseDto> rooms = new ArrayList<RoomsResponseDto>();

		Mockito.when(roomService.getRoomByHotelId(2)).thenReturn(rooms);
				
		List<RoomsResponseDto> room = roomDetailsController.getRoomByHotelId(2);
			Assertions.assertNotNull(room);
	}
}
