package com.it.jdbc.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import com.it.jdbc.dao.domain.User;

class ClassTest{
	public Class c;
	public ClassTest(Class c) {
		this.c = c;
	}
}

public class Test {

	public static void main(String[] args) throws Exception {
//		ClassTest ct = new ClassTest(User.class);
//		User u = (User) ct.c.newInstance();
		
		User user = User.class.newInstance();
		//获取指定字节码属性信息
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class,Object.class);
		//获取所有属性描述器
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			//获取所有属性名称
			System.out.println(pd.getName());
		}
		for (PropertyDescriptor pd : pds) {
			//获取所有方法名称
			System.out.println(pd.getReadMethod());
		}
		for (PropertyDescriptor pd : pds) {
			//获取所有方法名称
			System.out.println(pd.getWriteMethod());
		}

	}

}
