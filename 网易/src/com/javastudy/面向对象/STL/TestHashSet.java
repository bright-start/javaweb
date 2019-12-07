package com.javastudy.面向对象.STL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		//自定义类型
		HashSet<P> per = new HashSet<P>();
		per.add(new P("张三",15));
		per.add(new P("李四",17));
		per.add(new P("地方",25));
		per.add(new P("地方",25));
		per.add(new P("地方",25));
		System.out.println(per);	
	}
}
class P{
	private String name;
	private int age;
	P(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	//HashSet去重需要复写hashCode和equals方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		P other = (P) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
