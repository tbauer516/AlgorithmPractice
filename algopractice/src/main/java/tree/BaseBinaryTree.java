package tree;

public abstract class BaseBinaryTree {
	protected BaseTreeNode root;

	abstract public void insert(int value);
	abstract public boolean contains(int value);

	public BaseTreeNode find(int value) {
		if (this.root == null)
			return null;

		BaseTreeNode current = this.root;
		BaseTreeNode previous = null;
		while (current != null && current.value != value) {
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

	public int height(BaseTreeNode current) {
		if (current == null)
			return -1;

		return Math.max(height(current.left), height(current.right)) + 1;
	}

	public int depth(BaseTreeNode search) {
		int depth = 0;
		if (this.root == null || search == null)
			return -1;

		BaseTreeNode current = this.root;
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

	private void print(String prefix, BaseTreeNode current, boolean isLeft) {
		char leftBuffer = 'L'; // '\\'
		char rightBuffer = 'R'; // '|'
		if (current != null) {
			System.out.println (prefix + (!isLeft ? rightBuffer + "-- " : leftBuffer + "-- ") + current.value);
			print(prefix + (!isLeft ? "|   " : "    "), current.right, false);
			print(prefix + (!isLeft ? "|   " : "    "), current.left, true);
		}
	}

	public class BaseTreeNode {
		protected int value;
		protected BaseTreeNode left;
		protected BaseTreeNode right;

		public BaseTreeNode(int value, BaseTreeNode left, BaseTreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		public BaseTreeNode(int value) {
			this(value, null, null);
		}

		public BaseTreeNode() {
			this(0, null, null);
		}

		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}
	}
}
