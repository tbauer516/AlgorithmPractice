package sort;


import static sort.SortHelper.swap;

public class SelectionSort implements Sort {

	/**
	 * RUN      O(n^2)
	 * SPACE    O(1)
	 *
	 * @param arr, the array we are sorting
	 */
	public int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			swap(arr, i, minIndex);
		}
		return arr;
	}
}
