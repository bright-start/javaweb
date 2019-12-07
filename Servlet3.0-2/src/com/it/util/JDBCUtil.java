package com.it.util;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	
	private static Properties p = null;
	private static DataSource ds = null;
	
	static{
		try {
			p = new Properties();
			String path = JDBCUtil.class.getClassLoader().getResource("db.properties").getPath();
			FileInputStream f = new FileInputStream(path);
			p.load(f);
			ds = DruidDataSourceFactory.createDataSource(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDS() {
		return ds;
	}
	public static void close() {
		
	}
	
}
