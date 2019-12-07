package com.it.utils;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	
	private static DataSource ds = null;
	
	static {
		try {
			//1.加载配置文件
			Properties p = new Properties();
			//获取字节码目录
			String path = JDBCUtil.class.getClassLoader().getResource("db.properties").getPath();
			FileInputStream in = new FileInputStream(path);
			p.load(in);
			//ds = BasicDataSourceFactory.createDataSource(p);
			ds = DruidDataSourceFactory.createDataSource(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() {
		return ds;
	}

}
