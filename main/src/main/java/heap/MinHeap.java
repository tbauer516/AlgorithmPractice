package heap;

public class MinHeap {
	private HeapNode[] tree;
	private int size;
	private final int MIN_SIZE = 16;

	public MinHeap() {
		this.tree = new HeapNode[MIN_SIZE];
		size = 0;
	}

	public void insert(int val) {
		insert(val, 0);
	}

	public void insert(int val, int priority) {
		checkSize();

		HeapNode newNode = new HeapNode(val, priority);
		size++;
		int index = percolateUp(size, priority);
		tree[index] = newNode;
	}

	public HeapNode deleteMin() {
		if (this.isEmpty()) throw new IllegalStateException("Cannot delete min on an empty heap");
		HeapNode min = tree[1];
		int hole = percolateDown(1, tree[size].getPriority());
		tree[hole] = tree[size];
		size--;
		return min;
	}

	public HeapNode remove(int index) {
		if (index > size)
			return null;
		tree[index].priority = tree[1].priority - 1;
		decreaseKey(index);
		return deleteMin();
	}

	public void decreaseKey(int index) {
		if (index > size)
			return;
		HeapNode current = tree[index];
		tree[index].priority--;
		int hole = percolateUp(index, tree[index].getPriority());
		tree[hole] = current;
	}

	public void increaseKey(int index) {
		if (index > size)
			return;
		HeapNode current = tree[index];
		tree[index].priority++;
		int hole = percolateDown(index, tree[index].getPriority());
		tree[hole] = current;
	}

	private int percolateDown(int hole, int priority) {
		while (hole * 2 <= size) {
			int left = hole * 2;
			int right = left + 1;
			int target;
			if (tree[left].getPriority() < tree[right].getPriority() || right > size)
				target = left;
			else
				target = right;
			if (tree[target].getPriority() < priority) {
				tree[hole] = tree[target];
				hole = target;
			} else
				break;
		}
		return hole;
	}

	private int percolateUp(int hole, int priority) {
		while (hole > 1 && priority < tree[hole / 2].getPriority()) {
			tree[hole] = tree[hole / 2];
			hole = hole / 2;
		}
		return hole;
	}

	public boolean isEmpty() {
			return this.size == 0;
	}

	private void checkSize() {
		if (size == tree.length - 1)
			growTree();
		else if (tree.length > MIN_SIZE && size < tree.length / 4)
			shrinkTree();
	}

	private void growTree() {
		HeapNode[] larger = new HeapNode[tree.length * 2];
		for (int i = 0; i < tree.length; i++)
			larger[i] = tree[i];
		tree = larger;
	}

	private void shrinkTree() {
		HeapNode[] smaller = new HeapNode[tree.length / 2];
		for (int i = 0; i < size; i++)
			smaller[i] = tree[i];
		tree = smaller;
	}

	public void print() {
		print("", 1, true);
		System.out.println();
	}

	private void print(String prefix, int index, boolean isRoot) {
		char leftBuffer = 'L'; // '\\'
		char rightBuffer = 'R'; // '|'
		if (index <= size) {
			System.out.println (prefix + (index % 2 != 0 ? rightBuffer : leftBuffer) + "-- " + tree[index].getValue());
			print(prefix + (index % 2 != 0 && !isRoot ? "|   " : "    "), index * 2 + 1, false);
			print(prefix + (index % 2 != 0 && !isRoot ? "|   " : "    "), index * 2, false);
		}
	}

	private class HeapNode {
		private int priority;
		private int data;

		public HeapNode(int data) {
			this(data, 0);
		}

		public HeapNode(int data, int priority) {
			this.data = data;
			this.priority = priority;
		}

		public int getValue() {
			return this.data;
		}

		public int getPriority() {
			return this.priority;
		}

		public void setPriority(int val) {
			this.priority = val;
		}
	}
}
