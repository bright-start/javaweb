package com.shanny.demo;
/**
* @author 作者 whitexiaosheng
* @version 创建时间 2019年8月20日 上午9:31:22
*/
public class TimeTest {
	public static void main(String[] args) {
		sayHello();
		sayHello2("hello world");
	}

	public static void sayHello2(String string) {
		try {
			Thread.sleep(1000);
			System.out.println("hello");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sayHello() {
		try {
			Thread.sleep(2000);
			System.out.println("hello world");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
