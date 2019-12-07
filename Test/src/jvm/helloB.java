package jvm;

import java.awt.HeadlessException;

class helloA{
	public helloA() {
		System.out.println("helloA");
	}
	{
		System.out.println("i am classA");
	}
	static {
		System.out.println("staticA");
	}
}
public final class helloB extends helloA{
	public helloB() {
		System.out.println("helloB");
	}
	{
		System.out.println("i am classB");
	}
	static {
		System.out.println("staticB");
	}
	public static void main(String[] args) {
		helloB b;
		helloB a;
		helloB c;
		new helloB();
	}
}
