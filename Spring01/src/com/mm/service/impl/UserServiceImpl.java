package com.mm.service.impl;

import com.mm.dao.UserDao;
import com.mm.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	@Override
	public void addUser() {
		userDao.insertUser();

	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		
		this.userDao = userDao;
	}

}
