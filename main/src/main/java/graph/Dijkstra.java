package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

	public static String path(WeightedGraph g, Vertex v, Vertex w) {
		// priority queue for our Dijkstra search
		Queue<DijkstraNode> unknown = new PriorityQueue<>(g.getVertices().size(), new DijkstraNode.DijkstraNodeComparator());

		// map to keep track of our special Dijkstra nodes mapped to our normal vertices
		Map<Vertex, DijkstraNode> vertexToDijkstra = new HashMap<>();

		// populate the priority queue and the associative map
		for (Vertex node : g.getVertices()) {
			DijkstraNode temp = new DijkstraNode(node);
			if (node == v)
				temp.setCost(0);
			unknown.add(temp);
			vertexToDijkstra.put(node, temp);
		}

		// add all of the normal vertices children to the dijkstra nodes children
		for (Vertex node : vertexToDijkstra.keySet()) {
			for (Vertex child : g.getEdges(node).keySet()) {
				vertexToDijkstra.get(node).addChild(vertexToDijkstra.get(child));
			}
		}

		while (unknown.size() > 0) {
			DijkstraNode search = unknown.poll();
			search.setFound(true);
			for (DijkstraNode child : search.getChildren()) {
				if (!child.getFound()) {
					int newCost = search.getCost();
					Vertex searchVertex = search.getVertex();
					Map<Vertex, Integer> searchEdges = g.getEdges(searchVertex);
					newCost += searchEdges.get(child.getVertex());
					if (newCost < child.getCost()) {
						unknown.remove(child);
						child.setCost(newCost);
						unknown.add(child);
						child.setPath(search);
					}
				}
			}
		}

		DijkstraNode current = vertexToDijkstra.get(w);
		String path = "" + current.getVertex().getValue();
		while (current != vertexToDijkstra.get(v)) {
			current = current.getPath();
			path = current.getVertex().getValue() + " -> " + path;
		}
		return path;
	}

}
