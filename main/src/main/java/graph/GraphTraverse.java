package graph;

public interface GraphTraverse<T> {
	int size();
	T popItem();
	void pushItem(T item);
}
