package com.javastudy.面向对象;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 自定义日期模式 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat();
		//定义自己想要的模式
		String pattern = "yyyy-MM-dd HH:mm:ss";
		sd.applyPattern(pattern);
		//以指定的模式格式化那个日期
		String res = sd.format(date);
		System.out.println(res);
		
	}

}
