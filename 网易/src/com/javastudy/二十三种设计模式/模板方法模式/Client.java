package com.javastudy.二十三种设计模式.模板方法模式;

public class Client {
	public static int[] a = {10,32,1,9,5,7,12,0,4,3};
	public static void main(String[] args) {
		AbstractSort s = new ContextSort();
		s.showSortResult(a);
	}
}
