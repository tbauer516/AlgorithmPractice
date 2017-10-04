package graph;

import java.util.*;

public class UndirectedGraph {
	private Map<Vertex, Set<Vertex>> adjacencyList;

	public UndirectedGraph() {
		adjacencyList = new HashMap<>();
	}

	public void addVertex(Vertex v) {
		if (adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " already exists");
		adjacencyList.put(v, new  HashSet<>());
		return;
	}

	public void removeVertex(Vertex v) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		adjacencyList.remove(v);
		for(Vertex key : adjacencyList.keySet()) {
			Set<Vertex> set = adjacencyList.get(key);
			set.remove(v);
		}
	}

	public void addEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (adjacencyList.get(v).contains(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " already exists");
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v);
	}

	public void removeEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		if (!adjacencyList.get(v).contains(w))
			throw new IllegalArgumentException("Edge " + v.getValue() + " -> " + w.getValue() + " does not exist");
		adjacencyList.get(v).remove(w);
		adjacencyList.get(w).remove(v);
	}

	public boolean isEdge(Vertex v, Vertex w) {
		if (!adjacencyList.containsKey(v))
			throw new IllegalArgumentException("Vertex " + v.getValue() + " was not found");
		return adjacencyList.get(v).contains(w);
	}

	public String BFS(Vertex v, Vertex w) {
		return search(v, w, new TraverseQueue<>());
	}

	public String DFS(Vertex v, Vertex w) {
		return search(v, w, new TraverseStack<>());
	}

	private String search(Vertex v, Vertex w, GraphTraverse<Vertex> toVisit) {
		Set<Vertex> visited = new HashSet<>();
		Map<Vertex, String> pathTo = new HashMap<>();
		toVisit.pushItem(v);
		pathTo.put(v, "" + v.getValue());
		while (toVisit.size() > 0) {
			Vertex current = toVisit.popItem();
			if (searchHelper(current, w, visited, toVisit, pathTo))
				break;
		}
		return pathTo.get(w);
	}

	private boolean searchHelper(Vertex current, Vertex target, Set<Vertex> visited, GraphTraverse<Vertex> toVisit, Map<Vertex, String> pathTo) {
		if (current == target)
			return true;
		if (visited.contains(current))
			return false;

		visited.add(current);
		for (Vertex child : adjacencyList.get(current)) {
			pathTo.put(child, pathTo.get(current) + " -> " + child.getValue() );
			toVisit.pushItem(child);
		}
		return false;
	}

	public String toString() {
		String print = "";
		for (Vertex key : adjacencyList.keySet()) {
			print += key.getValue() + "\n";
			for (Vertex child : adjacencyList.get(key))
				print += "--" + child.getValue() + "\n";
		}
		return print;
	}
}
