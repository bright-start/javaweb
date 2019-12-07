package 数据结构;
/**
* @author 作者 whitexiaosheng
* @version 创建时间 2019年8月22日 下午10:43:50
* 
* 归并排序
*/
public class GBSort {
	public static void main(String[] args) {
		int[] a = {1, 5, 7, 2, 4, 3, 9, 6};
		for(int o=0;o<a.length;o++) {
			System.out.print(a[o]+" ");
		}
		System.out.println();
		MergeSort(a, 0, a.length-1);
	}

	private static void MergeSort(int[] arr, int l, int r) {
		if(l==r) {
			return ;
		}
		int m = (l + r) / 2;
		MergeSort(arr, l, m);
		MergeSort(arr, m+1, r);
		Merge(arr, l, m+1, r);
	}

	private static void Merge(int[] arr, int l, int m, int r) {
		int L[] = new int[m - l];
		int R[] = new int[r - m + 1];
		for(int i = l;i<m;i++) {
			L[i-l] = arr[i];
		}
		for(int i = m;i<=r;i++) {
			R[i-m] = arr[i];
		}
		int i = 0, j = 0;
		int k = l;
		while(i < L.length && j <R.length) {
			if(L[i] < R[j]) {
				arr[k] = L[i];
				i++;
				k++;
			}else {
				arr[k] = R[j];
				j++;
				k++;
			}
		}
		while(i < L.length) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j < R.length) {
			arr[k] = R[j];
			j++;
			k++;
		}
		for(int o=0;o<arr.length;o++) {
			System.out.print(arr[o]+" ");
		}
		System.out.println();
	}
}
