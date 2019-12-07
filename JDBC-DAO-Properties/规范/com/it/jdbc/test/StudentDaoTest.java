package com.it.jdbc.test;

import java.util.List;

import org.junit.Test;

import com.it.jdbc.dao.IStudentDao;
import com.it.jdbc.dao.domain.Student;
import com.it.jdbc.dao.impl.StudentDaoImpl;

public class StudentDaoTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	
		
	}
	@Test
	public void save() {
		Student stu = new Student();
		stu.setId(1);
		stu.setName("hui");
		stu.setAge(20);
		StudentDaoImpl stu_dao = new StudentDaoImpl();
		stu_dao.save(stu);
	}
	@Test
	public void update() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = new Student();
		stu.setName("lw");
		stu.setAge(21);
		dao.update(2,stu);
	}
	@Test
	public void delete() {
		IStudentDao dao = new StudentDaoImpl();
		dao.delete(1);
	}
	@Test
	public void get() {
		IStudentDao dao = new StudentDaoImpl();
		Student stu = dao.get(2);
		System.out.println(stu);
	}
	@Test
	public void getAll() {
		IStudentDao dao = new StudentDaoImpl();
		List<Student> allstu = dao.getAll();
		System.out.println(allstu);
	}

}
