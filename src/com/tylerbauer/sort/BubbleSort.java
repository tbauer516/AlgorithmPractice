package com.tylerbauer.sort;
import static com.tylerbauer.sort.SortHelper.*;

public class BubbleSort implements Sort {

	/**
	 * RUN      O(n^2)
	 * SPACE    O(1)
	 *
	 * @param arr, the array we are sorting
	 */
	public int[] sort(int[] arr) {
		for (int i = arr.length - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (arr[j] < arr[j - 1])
					swap(arr, (j - 1), j);
			}
		}
		return arr;
	}
}
