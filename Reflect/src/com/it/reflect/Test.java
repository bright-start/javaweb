package com.it.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) throws Exception {
//		Class clazz1 = Class.forName("com.it.reflect.Person");
//		
//		Class clazz2 = Person.class;
//		
//		Person p = new Person();
//		Class clazz3 = p.getClass();
		
//		System.out.println("==-----------------");
//		System.out.println(clazz1 == clazz2);
//		System.out.println(clazz2 == clazz3);
		
		Class clazz = Class.forName("com.it.reflect.Person");
		Person p = new Person();
		p.name = "zs";
		p.age = 12;
		p.show();
		
//		Constructor c = clazz.getConstructor(String.class,Integer.class,String.class);
//		Person per = (Person) c.newInstance("张飞",17);
//		per.show();
//		
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);
		f.set(p, "李白");
		p.show();
		
		Method m = clazz.getDeclaredMethod("eat",String.class);
		m.setAccessible(true);
		m.invoke(p, "香蕉");
		p.show();
	}

}
