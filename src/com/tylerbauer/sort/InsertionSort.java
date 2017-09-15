package com.tylerbauer.sort;
import static com.tylerbauer.sort.SortHelper.*;

public class InsertionSort implements Sort {

	/**
	 * RUN      O(n^2)
	 * SPACE    O(1)
	 *
	 * @param arr, the array we are sorting
	 */
	public int[] sort(int[] arr) {
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
