package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraTest {
	@Test
	public void path() throws Exception {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		Vertex six = new Vertex(6);
		Vertex seven = new Vertex(7);
		Vertex eight = new Vertex(8);
		testGraph.addVertex(one);
		testGraph.addVertex(two);
		testGraph.addVertex(three);
		testGraph.addVertex(four);
		testGraph.addVertex(five);
		testGraph.addVertex(six);
		testGraph.addVertex(seven);
		testGraph.addVertex(eight);

		testGraph.addEdge(one, two, 2);
		testGraph.addEdge(one, three, 1);
		testGraph.addEdge(one, four, 4);
		testGraph.addEdge(two, three, 5);
		testGraph.addEdge(two, five, 10);
		testGraph.addEdge(two, six, 2);
		testGraph.addEdge(three, one, 9);
		testGraph.addEdge(three, five, 11);
		testGraph.addEdge(four, three, 2);
		testGraph.addEdge(five, four, 7);
		testGraph.addEdge(five, seven, 1);
		testGraph.addEdge(six, eight, 3);
		testGraph.addEdge(seven, five, 3);
		testGraph.addEdge(seven, six, 2);
		testGraph.addEdge(eight, seven, 1);

		String path = Dijkstra.path(testGraph, one, five);
		System.out.println(path);
		assertEquals("1 -> 2 -> 6 -> 8 -> 7 -> 5", path);
	}

}