package com.it.jdbc.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {
	
	private static DataSource ds = null;
	private static Properties p = null;
	
	static {
		try {
			p = new Properties();
			FileInputStream in = new FileInputStream("resource/db.properties");
			p.load(in);
			ds = DruidDataSourceFactory.createDataSource(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDS() {
		return ds;
	}
	
	public static void close(Connection conn,PreparedStatement ps,ResultSet res) {
		if(res != null) {
			try {
				res.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(ps != null)
		{
			try {
				ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn,Statement st,ResultSet res) {
		if(res != null) {
			try {
				res.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(st != null)
		{
			try {
				st.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
