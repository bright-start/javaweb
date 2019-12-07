package com.it.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.it.dao.domain.Admin;
import com.it.utils.JDBCUtil;

public class LoginDao {

	public Admin checkLogin(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select *from admin where username=? and password=?";
		Admin admin = null;
		admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),username,password);
		System.out.println(admin);
		return admin;
	}

}
