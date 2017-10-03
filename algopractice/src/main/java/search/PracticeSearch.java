package search;

import java.lang.reflect.Method;
import java.util.Arrays;

public class PracticeSearch {
	public static void main(String[] args) {
		int[] test = new int[100];
		for (int i = 0; i < test.length; i++) test[i] = i;

		int[] shuffled = Arrays.copyOf(test, test.length);
		shuffle(shuffled);

		String[] unsortedSearches = {"LinearSearch"};
		String[] sortedSearches = {"BinarySearch"};
		int[] testVals = new int[5];
		for (int i = 0; i < testVals.length; i++) testVals[i] = (int) (Math.random() * 200);

		System.out.println();
		System.out.println("Unsorted:");
		printArray(shuffled);
		System.out.println();

		for (String unsortedSearch : unsortedSearches) {
			testMethod(unsortedSearch, shuffled, testVals);
		}

		System.out.println();
		System.out.println("Sorted:");
		printArray(test);
		System.out.println();

		for (String sortedSearch : sortedSearches) {
			testMethod(sortedSearch, test, testVals);
		}
	}

	public static void testMethod(String className, int[] testArray, int[] testVals) {
		int[] testArrayCopy = Arrays.copyOf(testArray, testArray.length);
		System.out.println(className + ":");
		try {
			Class<?> c = Class.forName("com.tylerbauer.search." + className);
			Object search = c.newInstance();
			Method method = search.getClass().getDeclaredMethod("search", int[].class, int.class);
			for (int testVal : testVals) {
				boolean result = (boolean) method.invoke(search, testArrayCopy, testVal);
				System.out.println(testVal + ": " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int randomArrayVal(int[] arr) {
		return arr[(int) (Math.random() * arr.length)];
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

	private static void shuffle(int[] vals) {
		for (int i = vals.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * vals.length);
			int temp = vals[i];
			vals[i] = vals[j];
			vals[j] = temp;
		}
	}
}
