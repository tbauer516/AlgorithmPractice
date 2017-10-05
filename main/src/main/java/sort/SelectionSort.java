package sort;


import static sort.SortHelper.swap;

public class SelectionSort {
	public static int[] sort(int[] arr) {
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
