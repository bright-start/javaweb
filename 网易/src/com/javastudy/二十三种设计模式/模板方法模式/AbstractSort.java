package com.javastudy.二十三种设计模式.模板方法模式;

/**
 * 数组排序功能分为两个部分，排序和输出 
 * 该部分是排序结果输出部分
 * @author Administrator
 *
 */
public abstract class AbstractSort {
	/**
	 * 将数组array由小到大排序
	 */
	protected abstract void sort(int[] array);
	
	public void showSortResult(int[] array) {
		this.sort(array);
		System.out.println("排序结果:");
		for(int i = 0; i < array.length; i++) {
			System.out.printf("%3s",array[i]);
		}
	}
}
