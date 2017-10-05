package sort;

import static sort.SortHelper.swap;

public class InsertionSort {
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j - 1] > arr[j]) {
				swap(arr, j, (j - 1));
				j--;
			}
		}
		return arr;
	}
}
