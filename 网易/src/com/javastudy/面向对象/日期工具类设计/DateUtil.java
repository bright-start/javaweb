package com.javastudy.面向对象.日期工具类设计;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	private DateUtil() {}
	
	public static String dateToString(Date date, String pattern) {
//		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//		String res = df.format(date);
		
		if(StringUtil.isBlank(pattern))
		{
			pattern = DEFAULT_PATTERN;
		}
		
		SimpleDateFormat sd = new SimpleDateFormat();
		sd.applyPattern(pattern);
		String res = sd.format(date);
		return res;
	}

	public static String dateToString(Date date) {
		return DateUtil.dateToString(date,"");
	}
	
	public static Date stringToDate(String source, String pattern) throws ParseException {
		
		if(StringUtil.isBlank(pattern))
		{
			pattern = DEFAULT_PATTERN;
		}
		
		SimpleDateFormat sd = new SimpleDateFormat();
		sd.applyPattern(pattern);
		Date res = sd.parse(source);
		return res;
	}
	
	public static Date stringToDate(String source) throws ParseException {
		return DateUtil.stringToDate(source, "");
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
	}

}
