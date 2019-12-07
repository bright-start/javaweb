
package com.javastudy.二十三种设计模式.模板方法模式;
/**
 * 数组排序功能实现
 * @author Administrator
 *
 */
public class ContextSort extends AbstractSort {

	protected void sort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			selectSort(array,i);
		}
	}

	private void selectSort(int[] array, int index) {
		int MinValue = 32767;//最小值变量
		int indexMin = 0;//最小值索引变量
		int Temp;//暂存变量
		for(int i = index; i < array.length; i++) {
			if(array[i] < MinValue) {
				MinValue = array[i];
				indexMin = i;
			}
		}
		Temp = array[index];
		array[index] = array[indexMin];
		array[indexMin] = Temp;
	}
}
