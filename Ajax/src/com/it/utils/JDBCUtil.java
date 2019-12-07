package com.it.utils;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	private static DataSource ds = null; 
	static {
		Properties p = new Properties();
		String path = JDBCUtil.class.getClassLoader().getResource("db.properties").getPath();
		FileInputStream in;
		try {
			in = new FileInputStream(path);
			p.load(in);
			ds = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	public static DataSource getDataSource() {
		return ds;
	}
}
