package com.javastudy.面向对象.日期工具类设计;

public class StringUtil {
	
	private StringUtil() {}
	
	public static boolean isBlank(String str) {
		// TODO 自动生成的方法存根
		return !StringUtil.hasLength(str);
	}
	
	public static boolean hasLength(String str) {
		// TODO 自动生成的方法存根
		return str != null && !"".equals(str.trim());
	}

	public static void main(String[] args) {
		
	}
}
