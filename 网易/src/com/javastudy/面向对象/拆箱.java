package com.javastudy.面向对象;

public class 拆箱 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		/**
		 * Integer
		 * 
		 */
		Integer num_1 = new Integer(11);
		Integer num_2 = Integer.valueOf(3);
		Integer num_3 = Integer.valueOf("1101");
		System.out.println(num_1);
		System.out.println(num_2);
		System.out.println(num_3);
		
		//拆箱
		int num_4=num_1.intValue();
		System.out.println("num_1 :拆箱："+num_4);
		//转换为二进制
		System.out.println(Integer.toBinaryString(4));
		
		//自动装箱
		Integer i=20;
				/*=Integer.intValue()*/
		//
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.BYTES);//字节数
		System.out.println(Integer.SIZE); //位数
	}

}
