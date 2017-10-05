package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTreeTest {
	@Test
	public void insert() throws Exception {
		BSTree tree = new BSTree();
		assertEquals(0, tree.size());
		tree.insert(1);
		assertEquals(1, tree.size());
		assertEquals(true, tree.contains(1));
	}

	@Test
	public void contains() throws Exception {
		BSTree tree = new BSTree();
		tree.insert(1);
		assertEquals(true, tree.contains(1));
	}

	@Test
	public void delete() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		BSTree tree = new BSTree();
		for (int val : test) {
			tree.insert(val);
		}
		assertEquals(true, tree.contains(300));
		tree.delete(300);
		assertEquals(false, tree.contains(300));
	}

	@Test
	public void print() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		BSTree tree = new BSTree();
		for (int val : test) {
			tree.insert(val);
		}
		tree.print();
	}

	@Test
	public void size() throws Exception {
		int[] test = {50, 32, 1, 0, 65, 74, 98, 300, 39, 24, 10, 64, 79, 45, 67, 55, 88, 22, 90, 99, 150, 5000};
		BSTree tree = new BSTree();
		for (int val : test) {
			tree.insert(val);
		}
		assertEquals(22, tree.size());
	}
}