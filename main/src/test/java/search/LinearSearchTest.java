package search;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinearSearchTest {
	@Test
	public void search() throws Exception {
		int[] test = new int[100];
		for (int i = 0; i < test.length; i++) test[i] = i;

		assertEquals(true, LinearSearch.search(test, 6));
		assertEquals(true, LinearSearch.search(test, 27));
		assertEquals(true, LinearSearch.search(test, 67));
		assertEquals(false, LinearSearch.search(test, -1));
		assertEquals(false, LinearSearch.search(test, 125));
		assertEquals(false, LinearSearch.search(test, 1000));
	}

}