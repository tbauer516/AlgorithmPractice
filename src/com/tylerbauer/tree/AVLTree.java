package com.tylerbauer.tree;

import java.util.*;

public class AVLTree extends BSTree {

	public void insert(int value) {
		AVLNode newNode = new AVLNode(value);
		super.insert(value, newNode);
		adjustHeight(value);
	}

	public BSTNode delete(int value) {
		BSTNode deleted = super.delete(value);
		adjustHeightDeleted((AVLNode) deleted);
		adjustHeight(value);
		return deleted;
	}

	protected AVLNode rotateLeft(AVLNode parent) {
		return rotateLeft(parent, 0);
	}

	protected AVLNode rotateLeft(AVLNode parent, int level) {
		if (level > 1)
			return parent;
		if (getBalance((AVLNode) parent.right) < 0)
			parent.right = rotateRight((AVLNode) parent.right, level++);
		AVLNode right = (AVLNode) parent.right;
		AVLNode rightLeft = (AVLNode) right.left;
		right.left = parent;
		parent.right = rightLeft;
		if (rightLeft != null)
			rightLeft.height = height(rightLeft);
		parent.height = height(parent);
		right.height = height(right);
		return right;
	}

	protected AVLNode rotateRight(AVLNode parent) {
		return rotateRight(parent, 0);
	}

	protected AVLNode rotateRight(AVLNode parent, int level) {
		if (level > 1)
			return parent;
		if (getBalance((AVLNode) parent.left) > 0)
			parent.left = rotateLeft((AVLNode) parent.left, level++);
		AVLNode left = (AVLNode) parent.left;
		AVLNode leftRight = (AVLNode) left.right;
		left.right = parent;
		parent.left = leftRight;
		if (leftRight != null)
			leftRight.height = height(leftRight);
		parent.height = height(parent);
		left.height = height(left);
		return left;
	}

	private void adjustHeight(int search) {
		adjustHeight(search, (AVLNode) this.root);
		int rootBal = getBalance((AVLNode) this.root);
		if (rootBal < -1)
			this.root = rotateRight((AVLNode) this.root);
		else if (rootBal > 1)
			this.root = rotateLeft((AVLNode) this.root);
	}

	private int adjustHeight(int search, AVLNode current) {
		if (current == null)
			return -1;

		if (search < current.value)
			adjustHeight(search, (AVLNode) current.left);
		else if (search > current.value)
			adjustHeight(search, (AVLNode) current.right);

		balance(current);

		current.height = 1 + Math.max(height((AVLNode) current.left), height((AVLNode) current.right));
		return current.height;
	}

	private int adjustHeightDeleted(AVLNode current) {
		if (current == null)
			return -1;

		int heightL = adjustHeightDeleted((AVLNode) current.left);
		int heightR = adjustHeightDeleted((AVLNode) current.right);
		int currentBal = getBalance(current);

		balance(current);

		current.height = 1 + Math.max(heightL, heightR);
		return current.height;
	}

	protected int height(AVLNode current) {
		if (current == null)
			return -1;

		int leftHeight = current.left == null ? -1 : ((AVLNode) current.left).height;
		int rightHeight = current.right == null ? -1 : ((AVLNode) current.right).height;

		return 1 + Math.max(leftHeight, rightHeight);
	}

	protected void balance(AVLNode current) {
		int balanceL = getBalance((AVLNode) current.left);
		int balanceR = getBalance((AVLNode) current.right);

		if (balanceL < -1)
			current.left = rotateRight((AVLNode) current.left);
		else if (balanceL > 1)
			current.left = rotateLeft((AVLNode) current.left);

		if (balanceR < -1)
			current.right = rotateRight((AVLNode) current.right);
		else if (balanceR > 1)
			current.right = rotateLeft((AVLNode) current.right);
	}

	protected int getBalance(AVLNode current) {
		if (current == null)
			return 0;

		return height((AVLNode) current.right) - height((AVLNode) current.left);
	}

	public void printHeight() {
		printHeight("", this.root, false);
	}

	private void printHeight(String prefix, BSTNode current, boolean isLeft) {
		char leftBuffer = 'L'; // '\\'
		char rightBuffer = 'R'; // '|'
		if (current != null) {
			System.out.println (prefix + (!isLeft ? rightBuffer + "-- " : leftBuffer + "-- ") + ((AVLNode) current).height);
			printHeight(prefix + (!isLeft ? "|   " : "    "), current.right, false);
			printHeight(prefix + (!isLeft ? "|   " : "    "), current.left, true);
		}
	}

	public void printBalance() {
		printBalance("", this.root, false);
	}

	private void printBalance(String prefix, BSTNode current, boolean isLeft) {
		char leftBuffer = 'L'; // '\\'
		char rightBuffer = 'R'; // '|'
		if (current != null) {
			System.out.println (prefix + (!isLeft ? rightBuffer + "-- " : leftBuffer + "-- ") + getBalance((AVLNode) current));
			printBalance(prefix + (!isLeft ? "|   " : "    "), current.right, false);
			printBalance(prefix + (!isLeft ? "|   " : "    "), current.left, true);
		}
	}

	public void testBalance() {
		if (this.root == null)
			return;

		Queue<AVLNode> nodes = new LinkedList<>();
		nodes.add((AVLNode) this.root);

		while (nodes.size() > 0) {
			AVLNode current = nodes.remove();
			if (current.left != null) nodes.add((AVLNode) current.left);
			if (current.right != null) nodes.add((AVLNode) current.right);

			if (Math.abs(getBalance(current)) > 1)
				throw new IllegalStateException("Node with value: " + current.value + " has illegal balance of: " + getBalance(current));
		}
	}

	protected class AVLNode extends BSTNode {
		protected int height;

		public AVLNode(int value) {
			super(value);
		}
	}
}
