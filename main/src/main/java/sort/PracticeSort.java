package sort;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PracticeSort {

	public static void main(String[] args) {
		int[] testCase = {5, 7, 4, 3, 2, 3, 9, 10, 5, 1, 0, 6};
		int[] sortCase = Arrays.copyOf(testCase, testCase.length);
		Arrays.sort(sortCase);

		String[] sorts = {"SelectionSort", "BubbleSort", "InsertionSort", "MergeSort", "QuickSort"};

		System.out.println("Unsorted:");
		printArray(testCase);
		System.out.println();

		for (String sort : sorts) {
			testMethod(sort, testCase);
		}

		System.out.println();
		System.out.println("Sorted:");
		printArray(sortCase);
	}

	public static void testMethod(String className, int[] testArray) {
		int[] testArrayCopy = Arrays.copyOf(testArray, testArray.length);
		System.out.println(className + ":");
		try {
			Class<?> c = Class.forName("com.tylerbauer.sort." + className);
			Object sort = c.newInstance();
			Method method = sort.getClass().getDeclaredMethod("sort", int[].class);
			int[] result = (int[]) method.invoke(sort, testArrayCopy);
			printArray(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void printArray(int[] arr) {
		String pretty = "[";
		for (int i = 0; i < arr.length; i++) {
			if (i > 0)
				pretty += ",";
			pretty += " " + arr[i];
		}
		pretty += " ]";
		System.out.println(pretty);
	}
}