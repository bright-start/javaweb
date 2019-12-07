package com.javastudy.面向对象.STL;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestList {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//容器泛型都是引用类型
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		System.out.println(list);
		System.out.println("--------------去重----------------");
		ArrayList arr = getSingleEle(list);
		System.out.println(arr);
		System.out.println("---------------------------------");
		//自定义类型
		List<People> per = new ArrayList<>();
		per.add(new People("张三",15));
		per.add(new People("李四",17));
		per.add(new People("地方",25));
		System.out.println(per);
		
	}

	private static ArrayList getSingleEle(List<Integer> list) {
		// TODO 自动生成的方法存根
		ArrayList newList = new ArrayList();
		ListIterator it = list.listIterator();
		while(it.hasNext()) {
			Object obj = it.next();
			if(!newList.contains(obj)) {
				newList.add(obj);
			}
		}
		return newList;
	}

}
class People{
	private String name;
	private int age;
	People(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
