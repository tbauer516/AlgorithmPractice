package sort;

import static sort.SortHelper.swap;

public class QuickSort {
	public static int[] sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private static void quickSort(int[] arr, int lowI, int highI) {
		if (lowI >= highI)
			return;
		int mid = partition(arr, lowI, highI);
		quickSort(arr, lowI, mid);
		quickSort(arr, mid + 1, highI);
	}

	private static int partition(int[] arr, int lowI, int highI) {
		if (highI <= lowI)
			return lowI;

//		int medI = ((highI - lowI) / 2) + lowI;
//		int pivot = Math.max(Math.min(arr[lowI], arr[medI]), Math.min(Math.max(arr[lowI], arr[medI]), arr[highI]));
		int pivot = arr[((int) (Math.random() * (highI - lowI + 1))) + lowI];

		lowI--;
		highI++;

		while (lowI < highI) {
			do {
				lowI++;
			} while (arr[lowI] < pivot);
			do {
				highI--;
			} while (arr[highI] > pivot);
			if (lowI >= highI) {
				break;
			}
			swap(arr, lowI, highI);
		}
		return highI;
	}
}
