package search;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
	@Test
	public void search() throws Exception {
		int[] test = new int[100];
		for (int i = 0; i < test.length; i++) test[i] = i;

		assertEquals(true, BinarySearch.search(test, 6));
		assertEquals(true, BinarySearch.search(test, 27));
		assertEquals(true, BinarySearch.search(test, 67));
		assertEquals(false, BinarySearch.search(test, -1));
		assertEquals(false, BinarySearch.search(test, 125));
		assertEquals(false, BinarySearch.search(test, 1000));
	}

}