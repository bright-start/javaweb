package com.it.service;

import java.sql.SQLException;

import com.it.dao.LoginDao;
import com.it.dao.domain.Admin;

public class LoginService {

	public Admin login(String username, String password) throws Exception {
		LoginDao loginDao = new LoginDao();
		Admin admin = null;
		admin = loginDao.checkLogin(username,password);
		if(admin != null) {
			return admin;
		}else {
			throw new Exception("用户名或密码错误");
		}
	}

}
