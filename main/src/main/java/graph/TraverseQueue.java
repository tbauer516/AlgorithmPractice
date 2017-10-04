package graph;

import java.util.LinkedList;

public class TraverseQueue<T> extends LinkedList<T> implements GraphTraverse<T> {

	public void pushItem(T item) {
		super.add(item);
	}

	public T popItem() {
		return super.remove();
	}
}
