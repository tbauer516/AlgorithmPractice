package com.tylerbauer.tree;

public class BSTree {
	protected BSTNode root;
	protected int size = 0;

	public void insert(int value) {
		BSTNode newNode = new BSTNode(value);
		insert(value, newNode);
	}

	protected void insert(int value, BSTNode newNode) {
		BSTNode last = find(value);

		if (last == null) {
			this.root = newNode;
			this.size++;
			return;
		}

		if (last.value == value)
			return;

		if (value < last.value)
			last.left = newNode;
		else if (value > last.value)
			last.right = newNode;
		this.size++;
	}

	public boolean contains(int value) {
		BSTNode last = find(value);

		if (last != null)
			return last.value == value;
		return false;
	}

	public BSTNode delete(int value) {
		if (this.root == null)
			return null;

		BSTNode current = this.root;
		BSTNode previous = this.root;
		while (current != null && current.value != value) {
			previous = current;
			if (value < current.value)
				current = current.left;
			else if (value > current.value)
				current = current.right;
		}

		if (current == null)
			return null;

		BSTNode deleted = null;
		if (current.left == null && current.right != null) {
			deleted = current.right;
		} else if (current.right == null && current.left != null) {
			deleted = current.left;
		} else if (current.left != null && current.right != null) {
			if (height(current.left) >= height(current.right)) {
				BSTNode last = current.left;
				if (last.right == null) {
					deleted = last;
					deleted.right = current.right;
				} else {
					while (last.right != null && last.right.right != null) {
						last = last.right;
					}
					BSTNode next = last.right;
					last.right = next.left;
					deleted = next;
					deleted.left = current.left;
					deleted.right = current.right;
				}
			} else {
				BSTNode last = current.right;
				if (last.left == null) {
					deleted = last;
					deleted.left = current.left;
				} else {
					while (last.left != null && last.left.left != null) {
						last = last.left;
					}
					BSTNode next = last.left;
					last.left = next.right;
					deleted = next;
					deleted.left = current.left;
					deleted.right = current.right;
				}
			}
		}

		if (this.root == current)
			this.root = deleted;
		else if (previous.left == current)
			previous.left = deleted;
		else if (previous.right == current)
			previous.right = deleted;
		this.size--;
		return current;
	}

	public BSTNode find(int value) {
		if (this.root == null)
			return null;

		BSTNode current = this.root;
		BSTNode previous = null;
		while (current != null && !current.hasValue(value)) {
			previous = current;
			if (value < current.value)
				current = current.left;
			else if (value > current.value)
				current = current.right;
		}

		if (current == null)
			return previous;
		return current;
	}

	protected int height(BSTNode current) {
		if (current == null)
			return -1;

		return 1 + Math.max(height(current.left), height(current.right));
	}

	protected int depth(BSTNode search) {
		int depth = 0;
		if (this.root == null || search == null)
			return -1;

		BSTNode current = this.root;
		while (current != null && current.value != search.value) {
			if (search.value < current.value)
				current = current.left;
			else if (search.value > current.value)
				current = current.right;
			depth++;
		}

		if (current == null)
			return -1;
		return depth;
	}

	public void print() {
		print("", this.root, false);
	}

	private void print(String prefix, BSTNode current, boolean isLeft) {
		char leftBuffer = 'L'; // '\\'
		char rightBuffer = 'R'; // '|'
		if (current != null) {
			System.out.println (prefix + (!isLeft ? rightBuffer + "-- " : leftBuffer + "-- ") + current.value);
			print(prefix + (!isLeft ? "|   " : "    "), current.right, false);
			print(prefix + (!isLeft ? "|   " : "    "), current.left, true);
		}
	}

	public void printInOrder() {
		String result = printInOrder("", this.root);
		System.out.println(result);
	}

	private String printInOrder(String result, BSTNode current) {
		if (current == null)
			return result;

		String left = printInOrder(result, current.left);
		result = left + current.value + " ";
		String right = printInOrder(result, current.right);

		return right;
	}

	public int size() {
		return this.size;
	}

	protected class BSTNode {
		protected int value;
		protected BSTNode left;
		protected BSTNode right;

		public BSTNode(int value, BSTNode left, BSTNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public BSTNode(int value) {
			this(value, null, null);
		}

		public BSTNode() {
			this(0, null, null);
		}

		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}

		public boolean isParent(BSTNode other) {
			return isParent(this, other);
		}

		public boolean isChild(BSTNode other) {
			return isParent(other, this);
		}

		private boolean isParent(BSTNode first, BSTNode other) {
			if (first == null || other == null)
				return false;

			if (first.left != null && first.left.value == other.value)
				return true;
			else if (first.right != null && first.right.value == other.value)
				return true;

			return false;
		}

		public boolean hasChild(int value) {
			return (this.left != null && this.left.value == value)
				|| (this.right != null && this.right.value == value);
		}

		public boolean hasValue(int value) {
			return this.value == value;
		}
	}
}
