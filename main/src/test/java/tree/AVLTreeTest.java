package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTest {

	@Test
	public void insert() throws Exception {
		AVLTree tree = new AVLTree();
		assertEquals(0, tree.size());
		tree.insert(1);
		assertEquals(1, tree.size());
		assertEquals(true, tree.contains(1));
	}

	@Test
	public void delete() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		AVLTree tree = new AVLTree();
		for (int val : test) {
			tree.insert(val);
		}
		assertEquals(true, tree.contains(300));
		tree.delete(300);
		assertEquals(false, tree.contains(300));
	}

	@Test
	public void testBalance() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		BSTree bst = new BSTree();
		AVLTree avl = new AVLTree();
		for (int val : test) {
			bst.insert(val);
			avl.insert(val);
		}
		assertEquals(6, bst.height(bst.root));
		assertEquals(4, avl.height(avl.root));
		assertEquals(true, avl.height(avl.root) < bst.height(bst.root));
	}

	@Test
	public void print() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		AVLTree tree = new AVLTree();
		for (int val : test) {
			tree.insert(val);
		}
		tree.print();
	}

}