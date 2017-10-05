package sort;

import static sort.SortHelper.swap;

public class BubbleSort {
	public static int[] sort(int[] arr) {
		for (int i = arr.length - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (arr[j] < arr[j - 1])
					swap(arr, (j - 1), j);
			}
		}
		return arr;
	}
}
