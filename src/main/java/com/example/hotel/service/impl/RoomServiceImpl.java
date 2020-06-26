package com.example.hotel.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.RoomDao;
import com.example.hotel.dto.RoomsResponseDto;
import com.example.hotel.exceptions.RoomNotFoundException;
import com.example.hotel.model.HotelRooms;
import com.example.hotel.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	private static Log logger=LogFactory.getLog(RoomServiceImpl.class);
	@Autowired
	RoomDao roomDao;
	
	/**
	 *{@inheritDoc}
	 */
	@Override
	public List<RoomsResponseDto> getRoomByHotelId(int hotelId) throws RoomNotFoundException {
		logger.info("executing the getRoomDetailsById method in RoomServiceImpl and returns the list of roomsresponses");
		Optional<List<HotelRooms>> ordersOptional=roomDao.findAllByHotelId(hotelId);
		if(ordersOptional.isPresent()) {
			List<HotelRooms> orders=ordersOptional.get();
			return orders.stream().map(order->getOrderResponse(order)).collect(Collectors.toList());
		}
		throw new RoomNotFoundException("No rooms found for the hotels..please visit again");
	}

	/**
	 * @param hotelrooms
	 * @return responsedto
	 */
	private RoomsResponseDto getOrderResponse(HotelRooms hotelrooms) {
		RoomsResponseDto responsedto=new RoomsResponseDto();
		BeanUtils.copyProperties(hotelrooms, responsedto);
		return responsedto;
	}

}
