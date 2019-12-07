package com.it.dao.impl;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.it.dao.Hero;
import com.it.utils.JDBCUtil;

public class dao {

	public Hero search(String name) throws SQLException{
		QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
		Hero hero = new Hero();
		String sql = "select *from hero where name = ?";
		hero = qr.query(sql,new BeanHandler<Hero>(Hero.class),name);
		System.out.println(hero);
		return hero;
	}
}
