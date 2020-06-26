package com.example.hotel.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.HotelDao;
import com.example.hotel.dto.HotelsResponseDto;
import com.example.hotel.exceptions.HotelsNotFoundException;
import com.example.hotel.model.Hotels;
import com.example.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	private static Log logger=LogFactory.getLog(HotelServiceImpl.class);

	@Autowired
	HotelDao hotelDao;
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public List<HotelsResponseDto> getHotelsByLocation(String hotelLocation) throws HotelsNotFoundException {
		logger.info("executing the getHotelsByLocation and return the list of hotelresponses");
		Optional<List<Hotels>> hotelsOptional=hotelDao.getHotelsByLocation(hotelLocation);
		if(hotelsOptional.isPresent()) {
		return hotelsOptional.get().stream().map(hotel->getHotelDto(hotel)).collect(Collectors.toList());
	}
		throw new HotelsNotFoundException("There exists no hotels with the given location:"+hotelLocation);

	}

	/**
	 * @param hotel
	 * @return responsedto
	 */
	private HotelsResponseDto getHotelDto(Hotels hotel) {
		HotelsResponseDto responseDto= new HotelsResponseDto();
		BeanUtils.copyProperties(hotel, responseDto);
		return responseDto;
	}
	
}
