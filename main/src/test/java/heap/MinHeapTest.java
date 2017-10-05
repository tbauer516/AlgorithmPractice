package heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinHeapTest {
	@Test
	public void insert() throws Exception {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 9, 9, 4, 5};
		MinHeap heap = new MinHeap();
		for (int i : test) {
			if (i == 9)
				heap.insert(i, -1);
			else
				heap.insert(i);
		}
		assertEquals(17, heap.size());
	}

	@Test
	public void deleteMin() throws Exception {
		MinHeap heap = new MinHeap();
		heap.insert(1, 1);
		heap.insert(2, 2);
		Integer min = heap.deleteMin();
		assertEquals(1, (int) min);
	}

	@Test
	public void remove() throws Exception {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 9, 9, 4, 5};
		MinHeap heap = new MinHeap();
		heap.insert(1, 1);
		heap.insert(2, 2);
		heap.insert(3, 3);
		heap.insert(4, 4);
		int removed = heap.remove(4);
		assertEquals(4, removed);
	}

	@Test
	public void decreaseKey() throws Exception {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 9, 9, 4, 5};
		MinHeap heap = new MinHeap();
		for (int i : test) {
			heap.insert(i, i);
		}
		assertEquals(1, (int) heap.peek());
		heap.decreaseKey(4, 5);
		assertEquals(4, (int) heap.peek());
	}

	@Test
	public void increaseKey() throws Exception {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 9, 9, 4, 5};
		MinHeap heap = new MinHeap();
		for (int i : test) {
			heap.insert(i, i);
		}
		assertEquals(1, (int) heap.peek());
		heap.increaseKey(1, 5);
		assertEquals(2, (int) heap.peek());
	}

	@Test
	public void isEmpty() throws Exception {
		MinHeap heap = new MinHeap();
		assertEquals(true, heap.isEmpty());
		heap.insert(1);
		assertEquals(false, heap.isEmpty());
	}

	@Test
	public void print() throws Exception {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 9, 9, 4, 5};
		MinHeap heap = new MinHeap();
		for (int i : test) {
			heap.insert(i, i);
		}
		heap.print();
	}

}