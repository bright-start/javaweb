package beanutilsTest;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		a.setId(1);
		a.setName("tom");
		a.setText("this is a");
		System.out.println(a);
		B b = new B(a);
		System.out.println(b);
		System.out.println(b.getTexts()[0]);
	}
}
