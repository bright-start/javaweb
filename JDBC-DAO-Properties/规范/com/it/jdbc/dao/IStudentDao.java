package com.it.jdbc.dao;

import java.util.List;

import com.it.jdbc.dao.domain.Student;

public interface IStudentDao {
//	保存数据
	void save(Student stu);
//	修改学生信息
	void update(int id,Student stu);
//	删除学生
	void delete(int id);
//	查找指定学生
	Student get(int id);
//	获取全部学生
	List<Student> getAll();
}
