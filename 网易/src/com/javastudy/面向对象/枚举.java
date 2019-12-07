package com.javastudy.面向对象;

public class 枚举 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(WeekDay.class);
		System.out.println(WeekDay.Monday);
		System.out.println("--------------");
		System.out.println(WeekDay.Friday .name());
		System.out.println(WeekDay.Wednesda.ordinal());
		
		System.out.println("---------------");
		WeekDay[] now = WeekDay.values();
		for(WeekDay day : now) {
			System.out.println(day);
		}
		
		System.out.println("-------------");
		WeekDay is = WeekDay.valueOf("Monday");
		System.out.println(is);
	}

}
enum WeekDay{
	Monday, Tuesday, Wednesda,Thursday, Friday, Saturday, Sunday 
}