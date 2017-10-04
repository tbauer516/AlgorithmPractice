package graph;

public class PracticeGraph {
	public static void main(String[] args) {
		UndirectedGraph test = new UndirectedGraph();
		Vertex five = new Vertex(5);
		Vertex six = new Vertex(6);
		Vertex four = new Vertex(4);
		Vertex three = new Vertex(3);
		test.addVertex(five);
		test.addVertex(six);
		test.addVertex(four);
		test.addVertex(three);
		test.addEdge(five, three);
		test.addEdge(five, four);
		test.addEdge(four, six);
		System.out.println(test.isEdge(five, three));
		System.out.println(test.toString());
		System.out.println(test.BFS(four, three));
		System.out.println(test.BFS(five, six));
		System.out.println(test.DFS(four, three));
		System.out.println(test.DFS(five, six));
	}
}
