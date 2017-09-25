package com.tylerbauer.list;

public class PracticeList {
	public static void main(String[] args) {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		insertTest(test);
		reverseTest(test);
	}

	private static void reverseTest(int[] listVals) {
		System.out.println();
		System.out.println("## LinkedList Reverse Test ##");
		System.out.println();

		LinkedList testList = new LinkedList();
		for (int val : listVals) {
			testList.add(val);
		}
		System.out.print(testList.size() + ":    ");
		testList.print();
		testList.reverse();
		System.out.print(testList.size() + ":    ");
		testList.print();
	}

	private static void insertTest(int[] listVals) {
		System.out.println();
		System.out.println("## LinkedList Insert Test ##");
		System.out.println();

		LinkedList testList = new LinkedList();
		for (int val : listVals) {
			testList.add(val);
		}
		testList.print();
		testList.remove();
		testList.delete(listVals[0]);
		testList.delete(listVals[7]);
		testList.delete(listVals[(int) (Math.random() * listVals.length)]);
		testList.delete(listVals[listVals.length - 1]);
		testList.remove();
		testList.print();
	}
}
