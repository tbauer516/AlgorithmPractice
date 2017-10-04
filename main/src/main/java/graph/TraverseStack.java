package graph;

import java.util.Stack;

public class TraverseStack<T> extends Stack<T> implements GraphTraverse<T> {

	public void pushItem(T item) {
		super.push(item);
	}

	public T popItem() {
		return super.pop();
	}
	
}
