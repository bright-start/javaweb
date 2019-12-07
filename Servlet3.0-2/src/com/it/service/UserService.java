package com.it.service;

import com.it.dao.domain.User;
import com.it.dao.impl.UserDao;

public class UserService {
	private UserDao userDao = new UserDao();
	public User getUserService(String username,String PASSWORD) throws Exception {
		User user = userDao.getUser(username,PASSWORD);
		return user;
	}
	public int addUserService(User user) throws Exception {
		int value = userDao.addUser(user);
		return value;
	}
}
