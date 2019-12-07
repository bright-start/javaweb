package com.it.reflect;

public class Person {
	public String name;
	public int age;
	private String gender;
	public String food;
	public Person() {
		super();
	}
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public void show() {
		System.out.println("我的名字是 "+this.name+"，年龄是"+this.age+"性别是"+this.gender);
	}
	
	private void eat() {
		System.out.println("我喜欢吃"+this.food);
	}
}
