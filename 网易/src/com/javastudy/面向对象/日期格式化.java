package com.javastudy.面向对象;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class 日期格式化 {

	public static void main(String[] args) throws ParseException {
		// TODO 自动生成的方法存根
		Date date = new Date();
		System.out.print("当前时间：");
		System.out.println(date);
		System.out.println("------------------");
		
		System.out.println(date.toLocaleString());
		
		DateFormat df1 = DateFormat.getInstance();  //默认格式
		String time1 = df1.format(date);
		System.out.println(time1);
		//长日期长时间
		DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		String time2 = df2.format(date);
		System.out.println(time2);
		//短日期短时间
		DateFormat df3 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
		String time3 = df3.format(date);
		System.out.println(time3);
		//日期
		DateFormat df4 = DateFormat.getDateInstance(DateFormat.SHORT);
		String time4 = df4.format(date);
		System.out.println(time4);
		//把字符串转换为日期
		DateFormat df5 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		String newStr = "2020年1月2日 下午13时14分59秒";
		Date date2 = df5.parse(newStr);
		System.out.println(date2);
	}

}
