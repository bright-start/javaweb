package com.javastudy.面向对象;

import java.math.BigDecimal;

public class 大精度小数 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		//BigDecimal 多用于计算金钱
		BigDecimal b = new BigDecimal("0.09");
		BigDecimal c = new BigDecimal("0.01");
		System.out.println(b.add(c));
		System.gc();
	}

}
