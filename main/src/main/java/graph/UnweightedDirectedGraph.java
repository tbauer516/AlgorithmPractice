package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnweightedDirectedGraph extends UnweightedGraph {

	public UnweightedDirectedGraph() {
		adjacencyList = new HashMap<>();
	}

	public void addEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (!adjacencyList.containsKey(w))
			throw new IllegalArgumentException("Vertex " + w.getValue() + " was not found");
		if (adjacencyList.get(v).contains(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " already exists");
		adjacencyList.get(v).add(w);
	}

	public void removeEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (!adjacencyList.containsKey(w))
			throw new IllegalArgumentException("Vertex " + w.getValue() + " was not found");
		if (!adjacencyList.get(v).contains(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " does not exist");
		adjacencyList.get(v).remove(w);
	}

}
