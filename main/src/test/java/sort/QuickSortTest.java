package sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
	@Test
	public void sort() throws Exception {
		int[] test = {5, 7, 4, 3, 2, 3, 9, 10, 5, 1, 0, 6};
		int[] sorted = QuickSort.sort(test);

		boolean isSorted = true;
		for (int i = 0; i < sorted.length - 1; i++) {
			if (sorted[i] > sorted[i + 1])
				isSorted = false;
		}
		assertEquals(true,  isSorted);
	}

	@Test
	public void print() {
		int[] test = {5, 7, 4, 3, 2, 3, 9, 10, 5, 1, 0, 6};
		int[] sorted = QuickSort.sort(test);

		String sortedString = "";
		for (int i = 0; i < sorted.length; i++) {
			sortedString += sorted[i] + ", ";
		}
		System.out.println(sortedString);
	}

}