package com.javastudy.面向对象;

public class 单例模式 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Example e1 = Example.getInstance();
		Example e2 = Example.getInstance();
		System.out.println(e1);
		System.out.println(e2);
	}

}
//饿汉模式
class Example{
	//1，必须要在该类中创建一个对象出来
	private static Example instance=new Example();
	//2，私有化自己的构造器，防止外界通过构造器来够构建新的对象
	private Example() {}
	//3.给外界提供一个方法，能够获取已经创建好的对象
	public static Example getInstance() {
		return instance;
	}
}
