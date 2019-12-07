package com.it.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.dao.domain.Products;
import com.it.util.JDBCUtil;

public class ProductsDao {
	private QueryRunner qr = new QueryRunner(JDBCUtil.getDS());
	public List<Products> getAllProduct() throws SQLException{
		String sql = "select *from products";
		List<Products> allProduct = qr.query(sql, new BeanListHandler<Products>(Products.class));
		System.out.println(allProduct);
		return allProduct;
	}
}
