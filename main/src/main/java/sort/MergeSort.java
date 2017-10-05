package sort;

public class MergeSort {
	public static int[] sort(int[] arr) {
		if (arr.length < 1)
			return arr;
		return split(arr);
	}

	private static int[] split(int[] input) {
		if (input.length == 1) {
			return input;
		}

		int m = input.length / 2;
		int[] left = new int[m];
		for (int i = 0; i < m; i++)
			left[i] = input[i];
		int[] right = new int[input.length - m];
		for (int i = 0; i < input.length - m; i++)
			right[i] = input[i + m];

		left = split(left);
		right = split(right);
		return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right) {
		int indexL = 0;
		int indexR = 0;
		int indexM = 0;
		int[] merged = new int[left.length + right.length];
		while (indexM < merged.length) {
			while (indexL < left.length && (indexR >= right.length || left[indexL] <= right[indexR])) {
				merged[indexM++] = left[indexL++];
			}
			while (indexR < right.length && (indexL >= left.length || right[indexR] <= left[indexL])) {
				merged[indexM++] = right[indexR++];
			}
		}
		return merged;
	}
}
