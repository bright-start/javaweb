package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.dao.domain.Category;
import com.it.utils.JDBCUtil;

public class CategoryDao {

	public List<Category> getAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select *from category";
		List<Category> allCategory = null;
		allCategory = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return allCategory;
		
	}
}
