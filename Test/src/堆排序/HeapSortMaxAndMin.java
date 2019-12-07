package ������;

public class HeapSortMaxAndMin {
	public static void main(String[] args) {
//		int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
		int[] array = { 3,4,1,2,5 };
		System.out.println("����ǰ:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println();
		System.out.println("�ָ���---------------");
		heapSort(array);
		System.out.println("�����:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}

	public static void heapSort(int[] array) {
		if (array == null || array.length == 1)
			return;
		buildArrayToHeap(array);
		System.out.println("�󶥶�:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
		// ������Ԫ��ת��Ϊ�󶥶�/С����
		for (int i = array.length - 1; i >= 1; i--) {
			// ���������һЩ�в�����Ŀǰarray[0]�ǵ�ǰ����������Ԫ�أ���Ҫ��ĩβ��Ԫ�ؽ�����Ȼ���ó�����Ԫ��
			swap(array, 0, i);
			/**
			 * ��������´α�����ʱ�򣬾�Ӧ���������һ��Ԫ�أ�Ҳ���������Ǹ� ֵ��Ȼ��ʼ���¹������ѶѵĴ�С�ͼ�ȥ1��Ȼ���0��λ�ÿ�ʼ����
			 * 
			 */
			buildMaxHeap(array, i, 0);
//			buildMinHeap(array, i, 0);
		}
	}

	// ������
	public static void buildArrayToHeap(int[] array) {
		if (array == null || array.length == 1)
			return;
		// ���ƹ�ʽ���� int root = 2*i, int left = 2*i+1, int right = 2*i+2;
		int cursor = array.length / 2;
		for (int i = cursor; i >= 0; i--) {
			// ����forѭ���£��Ϳ��Ե�һ���������
			 buildMaxHeap(array, array.length, i);
//			buildMinHeap(array, array.length, i);
		}
	}

	// �󶥶�
	public static void buildMaxHeap(int[] array, int heapSieze, int index) {
		// ���ӽڵ�
		int left = index * 2 + 1;
		// ���ӽڵ�
		int right = index * 2 + 2;
		// ��ʱ����Index��λ�þ������ֵ
		int maxValue = index;
		// ������ӽڵ��ֵ���ȵ�ǰ����ֵ�󣬾Ͱ����ֵ��λ�û������ӽڵ��λ��
		if (left < heapSieze && array[left] > array[maxValue]) {
			maxValue = left;
		}
		// ������ӽڵ��ֵ���ȵ�ǰ����ֵ�󣬾Ͱ����ֵ��λ�û������ӽڵ��λ��
		if (right < heapSieze && array[right] > array[maxValue]) {
			maxValue = right;
		}
		// ��������˵��������ӽڵ��ֵ�б��Լ���ģ�λ�÷����˽�����λ��
		if (maxValue != index) {
			swap(array, index, maxValue);
			// ��Ҫ����λ��Ԫ��
			// ������λ�ú���Ҫ�ж��ӽڵ��Ƿ���������ѵ����ʡ��������ʣ������ӽڵ㶼�ȸ��ڵ�С��
			buildMaxHeap(array, heapSieze, maxValue);
		}
	}

	// С����
	public static void buildMinHeap(int[] array, int heapSieze, int index) {
		int left = index * 2 + 1;
		// ���ӽڵ�
		int right = index * 2 + 2;
		// ���ӽڵ�
		int maxValue = index;
		// ��ʱ����Index��λ�þ�����Сֵ
		// ������ӽڵ��ֵ���ȵ�ǰ��С��ֵС���Ͱ���Сֵ��λ�û������ӽڵ��λ��
		if (left < heapSieze && array[left] < array[maxValue]) {
			maxValue = left;
		}
		// ������ӽڵ��ֵ���ȵ�ǰ��С��ֵС���Ͱ���Сֵ��λ�û������ӽڵ��λ��
		if (right < heapSieze && array[right] < array[maxValue]) {
			maxValue = right;
		}
		// ��������˵������ӽڵ��ֵ�б��Լ�С�ģ�λ�÷����˽�����λ��
		if (maxValue != index) {
			swap(array, index, maxValue);
			// ��Ҫ����λ��Ԫ��
			// ������λ�ú���Ҫ�ж��ӽڵ��Ƿ��������С�ѵ����ʡ���С���ʣ������ӽڵ㶼�ȸ��ڵ��
			buildMinHeap(array, heapSieze, maxValue);
		}
	}

	// ����Ԫ�ؽ���
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
