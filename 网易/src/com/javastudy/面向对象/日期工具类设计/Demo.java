package com.javastudy.面向对象.日期工具类设计;

import java.text.ParseException;
import java.util.Date;

public class Demo {

	public static void main(String[] args) throws ParseException {
		// TODO 自动生成的方法存根
		System.out.println(DateUtil.dateToString(new Date()));
		System.out.println(DateUtil.stringToDate("2018-06-17 10:33:33","yyyy-MM-dd"));
	}
}
