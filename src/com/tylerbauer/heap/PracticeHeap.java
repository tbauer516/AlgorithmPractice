package com.tylerbauer.heap;

public class PracticeHeap {
	public static void main(String[] args) {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 9, 9, 4, 5};
//		testInsert(test);
//		testDeleteMin(test);
//		testDecreaseKey(test);
//		testIncreaseKey(test);
		testRemove(test);
	}

	private static void testRemove(int[] testVals) {
		System.out.println();
		System.out.println("## MinHeap Remove Test ##");
		System.out.println();

		MinHeap heap = new MinHeap();
		for (int i : testVals) {
			if (i == 9)
				heap.insert(i, -1);
			else
				heap.insert(i);
		}
		heap.print();
		heap.remove(4);
		heap.print();
	}

	private static void testIncreaseKey(int[] testVals) {
		System.out.println();
		System.out.println("## MinHeap IncreaseKey Test ##");
		System.out.println();

		MinHeap heap = new MinHeap();
		for (int i : testVals) {
			if (i == 9)
				heap.insert(i, -1);
			else
				heap.insert(i);
		}
		heap.print();
		heap.increaseKey(4);
		heap.increaseKey(9);
		heap.print();
	}

	private static void testDecreaseKey(int[] testVals) {
		System.out.println();
		System.out.println("## MinHeap DecreaseKey Test ##");
		System.out.println();

		MinHeap heap = new MinHeap();
		for (int i : testVals) {
			if (i == 9)
				heap.insert(i, -1);
			else
				heap.insert(i);
		}
		heap.print();
		heap.decreaseKey(4);
		heap.decreaseKey(2);
		heap.print();
	}

	private static void testInsert(int[] testVals) {
		System.out.println();
		System.out.println("## MinHeap Insert Test ##");
		System.out.println();

		MinHeap heap = new MinHeap();
		for (int i : testVals) {
			if (i == 9)
				heap.insert(i, -1);
			else
				heap.insert(i);
		}
		heap.print();
	}

	private static void testDeleteMin(int[] testVals) {
		System.out.println();
		System.out.println("## MinHeap DeleteMin Test ##");
		System.out.println();

		MinHeap heap = new MinHeap();
		for (int i : testVals) {
			if (i == 9)
				heap.insert(i, -1);
			else
				heap.insert(i);
		}
		heap.print();
		heap.deleteMin();
		heap.deleteMin();
		heap.print();
	}
}
