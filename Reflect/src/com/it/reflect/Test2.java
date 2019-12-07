package com.it.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
//		list.add("sun");
		
		Class<?> clazz = Class.forName("java.util.ArrayList");
		Method m = clazz.getMethod("add", Object.class);
		
		m.invoke(list, "sun");
		System.out.println(list);
	}

}
