package com.it.jdbc.dao.impl;

import com.it.jdbc.dao.IUserDao;
import com.it.jdbc.dao.domain.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public void save(User u) {
		System.out.println("---------------");
		String sql = "insert into user (userName,password) values (?,?)";
		//int row = CURDTemplate.excuteUpdata(sql,u.getName(),u.getPassword());
		//System.out.println(row);
	}
}
