package graph;

import java.util.HashMap;

public class WeightedDirectedGraph extends WeightedGraph {

	public WeightedDirectedGraph() {
		adjacencyList = new HashMap<>();
	}

	public void addEdge(Vertex v, Vertex w, int weight) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (!adjacencyList.containsKey(w))
			throw new IllegalArgumentException("Vertex " + w.getValue() + " was not found");
		if (adjacencyList.get(v).containsKey(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " already exists");
		adjacencyList.get(v).put(w, weight);
	}

	public void removeEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (!adjacencyList.containsKey(w))
			throw new IllegalArgumentException("Vertex " + w.getValue() + " was not found");
		if (!adjacencyList.get(v).containsKey(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " does not exist");
		adjacencyList.get(v).remove(w);
	}

}
