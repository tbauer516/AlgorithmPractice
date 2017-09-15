package com.tylerbauer.tree;

public class BinaryTree extends BaseBinaryTree {
	protected int size = 0;

	public void insert(int value) {
		BaseTreeNode newNode = new BaseTreeNode(value);
		insert(value, newNode);
	}

	private void insert(int value, BaseTreeNode newNode) {
		BaseTreeNode last = find(value);

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
		BaseTreeNode last = find(value);

		if (last != null)
			return last.value == value;
		return false;
	}

	public void delete(int value) {
		if (this.root == null)
			return;

		BaseTreeNode current = this.root;
		BaseTreeNode previous = this.root;
		while (current != null && current.value != value) {
			previous = current;
			if (value < current.value)
				current = current.left;
			else if (value > current.value)
				current = current.right;
		}

		if (current == null)
			return;

		BaseTreeNode deleted = null;
		if (current.left == null && current.right != null) {
			deleted = current.right;
		} else if (current.right == null && current.left != null) {
			deleted = current.left;
		} else if (current.left != null && current.right != null) {
			if (height(current.left) >= height(current.right)) {
				BaseTreeNode last = current.left;
				if (last.right == null) {
					deleted = last;
					deleted.right = current.right;
				} else {
					while (last.right != null && last.right.right != null) {
						last = last.right;
					}
					BaseTreeNode next = last.right;
					last.right = next.left;
					deleted = next;
					deleted.left = current.left;
					deleted.right = current.right;
				}
			} else {
				BaseTreeNode last = current.right;
				if (last.left == null) {
					deleted = last;
					deleted.left = current.left;
				} else {
					while (last.left != null && last.left.left != null) {
						last = last.left;
					}
					BaseTreeNode next = last.left;
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
	}

	public int size() {
		return this.size;
	}
}
