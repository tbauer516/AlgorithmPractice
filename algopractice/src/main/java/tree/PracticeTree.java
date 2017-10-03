package tree;

public class PracticeTree {
	public static void main(String[] args) {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		int[] test2 = {1, 79, 50, 45, 10, 98, 22, 67, 0, 55, 90, 5000, 74, 65, 99, 300, 39, 88, 150, 32, 24, 64};
		int[] test3 = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] test4 = {1, 2, 4, 5, 6, 3, 7, 8};
		testFind(test);
		testDelete(test);
		testAVLInsert(test);
		testAVLDelete(test);
		shuffle(test);
		testAVLDelete(test);
		testAVLInsertLarge();
	}

	private static void testAVLInsertLarge() {
		System.out.println();
		System.out.println("## AVLTree Large Insert ##");
		System.out.println();

		for (int i = 0; i < 10000; i++) {
			AVLTree avl = new AVLTree();
			for (int j = 0; j < 100; j++) {
				avl.insert((int) (Math.random() * 1000));
			}
			avl.testBalance();
		}
	}

	private static void testAVLDelete(int[] treeVals) {
		System.out.println();
		System.out.println("## AVLTree Delete Test ##");
		System.out.println();

		AVLTree avl = new AVLTree();
		BSTree bst = new BSTree();
		int[] deletes = new int[] {65, 24, 67};
		for (int val : treeVals) {
			avl.insert(val);
			bst.insert(val);
		}
		avl.print();
		for (int val : deletes) {
			avl.delete(val);
			bst.delete(val);
		}
		avl.printInOrder();
		bst.printInOrder();
		System.out.println();
		avl.printHeight();
	}

	private static void testAVLInsert(int[] treeVals) {
		System.out.println();
		System.out.println("## AVLTree Insert Test ##");
		System.out.println();

		AVLTree avl = new AVLTree();
		for (int val : treeVals) {
			avl.insert(val);
		}
		avl.print();
	}

	private static void testFind(int[] treeVals) {
		System.out.println();
		System.out.println("## BSTree Find Test ##");
		System.out.println();

		BSTree bst = new BSTree();
		for (int val : treeVals) {
			bst.insert(val);
		}
		for (int val : treeVals) {
			BSTree.BSTNode findNode = bst.find(val);
			System.out.println(findNode == null ? "null" : findNode.value);
			if (findNode.left != null)
				System.out.println("l: " + findNode.left.value);
			if (findNode.right != null)
				System.out.println("r: " + findNode.right.value);
			System.out.println();
		}
	}

	private static void testDelete(int[] treeVals) {
		System.out.println();
		System.out.println("## BSTree Delete Test ##");
		System.out.println();

		BSTree bst = new BSTree();
		for (int val : treeVals) {
			bst.insert(val);
		}
		System.out.println(bst.size());
		bst.print();
		System.out.println();

		for (int i = 0; i < 3; i++) {
			int toDelete = treeVals[(int) (Math.random() * treeVals.length)];
			System.out.println(toDelete);
			bst.delete(toDelete);
		}

		System.out.println();
		System.out.println(bst.size());
		bst.print();
		System.out.println();
		System.out.println();

		int[] contains = {2, 1, 4, 5, 8, 9};
		for (int val : contains) {
			System.out.print(bst.contains(val) + " ");
		}
	}

	private static void shuffle(int[] vals) {
		for (int i = vals.length - 1; i > 0; i--) {
			int j = (int) (Math.random() * vals.length);
			int temp = vals[i];
			vals[i] = vals[j];
			vals[j] = temp;
		}
	}

	private static void arrayPrint(int[] vals) {
		String result = "";
		for (int i = 0; i < vals.length; i++) {
			result += vals[i];
			if (i < vals.length - 1)
				result += ", ";
		}
		System.out.println(result);
	}
}
