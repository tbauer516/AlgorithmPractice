package list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
	@Test
	public void add() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		LinkedList testList = new LinkedList();
		for (int val : test) {
			testList.add(val);
		}
		assertEquals(22, testList.size());
	}

	@Test
	public void remove() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		LinkedList testList = new LinkedList();
		for (int val : test) {
			testList.add(val);
		}
		assertEquals(22, testList.size());
		int removed = testList.remove();
		assertEquals(50, removed);
		assertEquals(21, testList.size());
	}

	@Test
	public void delete() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		LinkedList testList = new LinkedList();
		for (int val : test) {
			testList.add(val);
		}
		assertEquals(22, testList.size());
		int deleted = testList.delete(32);
		assertEquals(32, deleted);
		assertEquals(21, testList.size());
	}

	@Test
	public void reverse() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300};
		LinkedList testList = new LinkedList();
		for (int val : test) {
			testList.add(val);
		}
		assertEquals("root -> 50 -> 32 -> 1 -> 0 -> 65 -> 74 -> 98 -> 300", testList.toString());
		testList.reverse();
		assertEquals("root -> 300 -> 98 -> 74 -> 65 -> 0 -> 1 -> 32 -> 50", testList.toString());
	}

	@Test
	public void print() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		LinkedList testList = new LinkedList();
		for (int val : test) {
			testList.add(val);
		}
		System.out.println(testList.toString());
	}

}