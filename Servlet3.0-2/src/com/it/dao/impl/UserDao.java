package com.it.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.it.dao.domain.User;
import com.it.util.JDBCUtil;

public class UserDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
	//查询一个
	public User getUser(String username,String PASSWORD) throws SQLException {
		String sql = "select *from user where username=? and PASSWORD=?";
		User user = qr.query(sql,new BeanHandler<User>(User.class), username,PASSWORD);
		System.out.println(user);
		return user;
	}
	public int addUser(User user) throws SQLException {
		// TODO 自动生成的方法存根
		String sql = "insert into user(username,PASSWORD,gender,email,telephone,introduce,activeCode,state,role,registTime) values(?,?,?,?,?,?,?,?,?,?)";
		int value = qr.update(sql,user.getUsername(),user.getPASSWORD(),user.getGender(),user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActiveCode(),user.getState(),user.getRole(),user.getRegistTime());
		System.out.println("-------------add success-------------");
		return value;
	}

}
