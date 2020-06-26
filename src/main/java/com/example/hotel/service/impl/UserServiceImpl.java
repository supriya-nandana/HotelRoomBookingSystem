package com.example.hotel.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.dao.UserDao;
import com.example.hotel.exceptions.InvalidCredentialsException;
import com.example.hotel.model.User;
import com.example.hotel.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);
	@Autowired
	UserDao userDao;

	/**
	 *{@inheritDoc}
	 */
	@Override
	public boolean authenticate(String userName, String password) throws InvalidCredentialsException {
		logger.info("authenticating the user details in userserviceimpl");
		User user=userDao.findByUserNameAndPassword(userName, password);
		if(user!=null) return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials"); 
	}
	

}
