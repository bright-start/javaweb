package com.it.jdbc.test;

import org.junit.Test;

import com.it.jdbc.dao.IUserDao;
import com.it.jdbc.dao.domain.User;
import com.it.jdbc.dao.impl.UserDaoImpl;

public class UserDaoTest {

	@Test
	void save() {
		User user = new User();
		user.setName("wusha");
		user.setPassword("123456789");
		IUserDao dao = new UserDaoImpl();
		dao.save(user);
		
	}

}
