package list;

public class LinkedList {
	protected ListNode root;
	protected ListNode last;
	protected int size;

	public LinkedList() {
		this.root = null;
		this.last = null;
	}

	public void add(int value) {
		ListNode newNode = new ListNode(value);

		if (this.root == null) {
			this.root = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = last.next;
		}
		size++;
	}

	public ListNode remove() {
		if (this.root == null)
			return null;

		ListNode removed = this.root;
		this.root = this.root.next;
		this.size--;
		return removed;
	}

	public ListNode delete(int value) {
		if (this.root == null)
			return null;

		if (this.root.value == value)
			return remove();

		ListNode current = this.root;
		while (current.next != null && current.next.value != value) {
			current = current.next;
		}

		ListNode removed = null;
		if (current.next != null && current.next.value == value) {
			removed = current.next;
			current.next = current.next.next;
			this.size--;
		}

		if (removed == null)
			return null;

		if (removed.next == null)
			this.last = current;

		return removed;
	}

	public void reverse() {
		ListNode newRoot = null;
		this.last = this.root;
		ListNode current = this.root;
		while (current != null) {
			ListNode tempRoot = newRoot;
			newRoot = current;
			current = current.next;
			newRoot.next = tempRoot;
		}
		this.root = newRoot;
		this.last.next = null;
	}

	public int size() {
		return this.size;
	}

	public void  print() {
		ListNode current = this.root;
		String result = "root";
		while (current != null) {
			result += " -> " + current.value;
			current = current.next;
		}
		System.out.println(result);
	}

	protected class ListNode {
		protected int value;
		protected ListNode next;

		protected ListNode(int value) {
			this.value = value;
			this.next = null;
		}
	}
}
