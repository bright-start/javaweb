package com.it.jdbc.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.jdbc.dao.IStudentDao;
import com.it.jdbc.dao.domain.Student;
import com.it.jdbc.util.JDBCUtil;


public class StudentDaoImpl implements IStudentDao {

	@Override
	public void save(Student stu) {

		String sql = "insert into stu values(?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			int row = qr.update(sql, stu.getId(),stu.getName(),stu.getAge());
			System.out.println(row);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(int id,Student stu) {

		String sql = "update stu set name = ?,age = ? where id = ?";
		System.out.println(sql);
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		System.out.println(qr);
		try {
			int row = qr.update(sql, stu.getName(),stu.getAge(),id);
			System.out.println(row);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
	
		String sql = "delete from stu where id = ?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			int row = qr.update(sql, id);
			System.out.println(row);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public Student get(int id) {	
		String sql = "select *from stu where id = ?";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			return qr.query(sql, new BeanHandler<Student>(Student.class),id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Student> getAll() {
		String sql = "select *from stu";
		QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
		try {
			return qr.query(sql,new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
}
