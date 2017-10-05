package graph;

import java.util.HashMap;

public class UnweightedUndirectedGraph extends UnweightedGraph {

	public UnweightedUndirectedGraph() {
		adjacencyList = new HashMap<>();
	}

	public void addEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (!adjacencyList.containsKey(w))
			throw new IllegalArgumentException("Vertex " + w.getValue() + " was not found");
		if (adjacencyList.get(v).contains(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " already exists");
		if (adjacencyList.get(w).contains(v))
			throw new IllegalArgumentException("Edge " + w.getValue() + " -> " + v.getValue() + " already exists");
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v);
	}

	public void removeEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (!adjacencyList.containsKey(w))
			throw new IllegalArgumentException("Vertex " + w.getValue() + " was not found");
		if (!adjacencyList.get(v).contains(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " does not exist");
		if (!adjacencyList.get(w).contains(v))
			throw new IllegalArgumentException("Edge " + w.getValue() + " -> " + v.getValue() + " does not exist");
		adjacencyList.get(v).remove(w);
		adjacencyList.get(w).remove(v);
	}

}
