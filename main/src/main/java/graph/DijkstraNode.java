package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class DijkstraNode {
	private Vertex vertex;
	private boolean found;
	private int cost;
	private DijkstraNode path;
	private Set<DijkstraNode> children;

	public DijkstraNode(Vertex v) {
		this(v, Integer.MAX_VALUE);
	}

	public DijkstraNode(Vertex v, int cost) {
		this.vertex = v;
		this.found = false;
		this.cost = cost;
		this.path = null;
		this.children = new HashSet<>();
	}

	public void setCost(int cost) { this.cost = cost; }
	public void setFound(boolean found) { this.found = found; }
	public void setPath(DijkstraNode path) { this.path = path; }
	public void addChild(DijkstraNode child) { this.children.add(child); }

	public Vertex getVertex() { return this.vertex; }
	public int getCost() { return this.cost; }
	public boolean getFound() { return this.found; }
	public DijkstraNode getPath() { return this.path; }
	public Set<DijkstraNode> getChildren() { return this.children; }

	public static class DijkstraNodeComparator implements Comparator<DijkstraNode> {

		@Override
		public int compare(DijkstraNode o1, DijkstraNode o2) {
			return o1.getCost() - o2.getCost();
		}

		@Override
		public boolean equals(Object obj) {
			return false;
		}
	}
}
