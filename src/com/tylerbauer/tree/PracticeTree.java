package com.tylerbauer.tree;

public class PracticeTree {
	public static void main(String[] args) {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		BinaryTree binaryTree = new BinaryTree();
		for (int val : test) {
			binaryTree.insert(val);
		}
		System.out.println(binaryTree.size());
		binaryTree.print();
		System.out.println();

		for (int i = 0; i < 3; i++) {
			int toDelete = test[(int) (Math.random() * test.length)];
			System.out.println(toDelete);
			binaryTree.delete(toDelete);
		}

		System.out.println();
		System.out.println(binaryTree.size());
		binaryTree.print();
		System.out.println();
		System.out.println();

		int[] contains = {2, 1, 4, 5, 8, 9};
		for (int val : contains) {
			System.out.print(binaryTree.contains(val) + " ");
		}

		// =======================


	}
}
