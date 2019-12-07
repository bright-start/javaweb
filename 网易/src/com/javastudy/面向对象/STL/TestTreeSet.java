package com.javastudy.面向对象.STL;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		TreeSet<String> s = new TreeSet<String>();
		s.add("aa");
		s.add("av");
		s.add("acf");
		System.out.println(s);
		TreeSet<Person> set = new TreeSet<Person>();
		set.add(new Person("张三",15));
		set.add(new Person("李四",17));
		set.add(new Person("地方",25));
		System.out.println(set);
	}

}
//TreeSet添加自定义对象
//实现comparable接口
//覆盖compareTo方法
class Person implements Comparable {
	private String name;
	private int age;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	//如果返回值是0 ，只添加一个元素
	//如果返回值是正数，正序添加元素
	//如果返回值是负数，逆序添加元素
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		return 1;
	}

}
