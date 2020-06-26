package com.example.hotel;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.hotel.dao.HotelDao;
import com.example.hotel.service.impl.HotelServiceImpl;


	@ExtendWith(MockitoExtension.class)
	public class HotelServiceImplTests {

		@Mock
		HotelDao hotelDao;
		
		@InjectMocks
		HotelServiceImpl hotelServiceImpl;
		
		/*
		@Test
		public void searchHotelsByLocationTest() {

			Optional<List<Hotels>> hotelsResponce = Optional.of(new ArrayList<HotelsResponseDto>());
			Hotels hotels=new Hotels();
			hotels.setHotelLocation("chennai");
			hotelDao.getHotelsByLocation("chennai");
            hotelsResponce.
			
            hotels = Mockito
					.when(hotelDao.getHotelsByLocation("chennai")).thenReturn(hotelsResponce);
						
			Assertions.assertNotNull(hotelsResponce);
			
			*/

			
		}

	

