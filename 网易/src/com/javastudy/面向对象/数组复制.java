package com.javastudy.面向对象;

public class 数组复制 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] array1 = new int[1000];
		for(int i = 0; i < array1.length; i ++) {
			array1[i] = i + 1;
		}
		int[] array2 = new int[array1.length];
		System.arraycopy(array1, 0, array2, 0, array1.length);
		long time1 = System.currentTimeMillis();  //1970年开始计算时间
		for(int i : array2) {
			System.out.print(i+" ");
			if(i % 10 == 0)
				System.out.println();
		}
		System.out.println();
		long time2 = System.currentTimeMillis();
		System.out.println("系统总耗时："+(time2-time1)+" ms");
		
	}

}
