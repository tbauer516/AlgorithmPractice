package graph;

import java.util.HashMap;

public class UndirectedEdgeList {
	private boolean[][] edges;
	private HashMap<Vertex, Integer> indexes;
	private int size;

	public UndirectedEdgeList() {
		this.edges = new boolean[8][8];
		this.indexes = new HashMap<>();
		this.size = 0;
	}

	public void insert(Vertex source, Vertex dest) throws Exception {
		setEdge(source, dest, true);
	}

	public void remove(Vertex source, Vertex dest) throws Exception {
		setEdge(source, dest, false);
	}

	public boolean isEdge(Vertex source, Vertex dest) throws Exception {
		checkValidEdges(source, dest);
		return edges[indexOfVertex(source)][indexOfVertex(dest)];
	}

	public void setEdge(Vertex source, Vertex dest, boolean value) {
		checkValidEdges(source, dest);
		setEdge(indexOfVertex(source), indexOfVertex(dest), value);
	}

	private void checkValidEdges(Vertex source, Vertex dest) {
		int indexSource = indexOfVertex(source);
		int indexDest = indexOfVertex(dest);
		if (indexSource == -1)
			addVertex(source);
		if (indexDest == -1)
			addVertex(dest);
	}

	private void setEdge(int source, int dest, boolean value) {
		edges[source][dest] = value;
		edges[dest][source] = value;
	}

	private int indexOfVertex(Vertex v) {
		if (!indexes.containsKey(v))
			return -1;
		return indexes.get(v);
	}

	private void addVertex(Vertex v) {
		checkSize();
		indexes.put(v, size);
		size++;
	}

	private void removeVertex(Vertex v) {
		indexes.remove(v);
		size--;
		checkSize();
	}

	private void checkSize() {
		if (edges.length <= size)
			edgeListGrow();
		else if (edges.length > 8 && edges.length / 4 >= size)
			edgeListShrink();
	}

	private void edgeListGrow() {
		boolean[][] larger = new boolean[edges.length  * 2][edges.length * 2];
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].length; j++) {
				larger[i][j] = edges[i][j];
			}
		}
		edges = larger;
	}

	private void edgeListShrink() {
		boolean[][] smaller = new boolean[edges.length / 2][edges.length / 2];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				smaller[i][j] = edges[i][j];
			}
		}
		edges = smaller;
	}
}
