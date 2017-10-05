package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeightedDirectedGraphTest {

	@Test
	public void addVertex() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex one = new Vertex(1);
		testGraph.addVertex(one);
		assertEquals(true, testGraph.containsVertex(one));
		assertEquals(false, testGraph.containsVertex(new Vertex(2)));
	}

	@Test
	public void removeVertex() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex one = new Vertex(1);
		testGraph.addVertex(one);
		assertEquals(true, testGraph.containsVertex(one));
		testGraph.removeVertex(one);
		assertEquals(false, testGraph.containsVertex(one));
	}

	@Test
	public void addEdge() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex test3 = new Vertex(3);
		Vertex test4 = new Vertex(4);
		testGraph.addVertex(test3);
		testGraph.addVertex(test4);
		assertEquals(false, testGraph.isEdge(test3, test4));
		testGraph.addEdge(test3, test4, 1);
		assertEquals(true, testGraph.isEdge(test3, test4));
	}

	@Test
	public void removeEdge() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex test3 = new Vertex(3);
		Vertex test4 = new Vertex(4);
		testGraph.addVertex(test3);
		testGraph.addVertex(test4);
		testGraph.addEdge(test3, test4, 1);
		assertEquals(true, testGraph.isEdge(test3, test4));
		testGraph.removeEdge(test3, test4);
		assertEquals(false, testGraph.isEdge(test3, test4));
	}

	@Test
	public void isEdge() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex test3 = new Vertex(3);
		Vertex test4 = new Vertex(4);
		testGraph.addVertex(test3);
		testGraph.addVertex(test4);
		assertEquals(false, testGraph.isEdge(test3, test4));
		testGraph.addEdge(test3, test4, 1);
		assertEquals(true, testGraph.isEdge(test3, test4));
	}

	@Test
	public void BFS() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		testGraph.addVertex(one);
		testGraph.addVertex(two);
		testGraph.addVertex(three);
		testGraph.addVertex(four);
		testGraph.addVertex(five);
		testGraph.addEdge(one, two, 1);
		testGraph.addEdge(two, three, 1);
		testGraph.addEdge(three, four, 1);
		testGraph.addEdge(four, five, 1);
		testGraph.addEdge(two, five, 3);
		testGraph.addEdge(three, one, 3);
		assertEquals("1 -> 2 -> 3 -> 4", testGraph.BFS(one, four));
	}

	@Test
	public void DFS() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		testGraph.addVertex(one);
		testGraph.addVertex(two);
		testGraph.addVertex(three);
		testGraph.addVertex(four);
		testGraph.addVertex(five);
		testGraph.addEdge(one, two, 1);
		testGraph.addEdge(three, four, 1);
		testGraph.addEdge(four, five, 1);
		testGraph.addEdge(three, one, 1);
		assertEquals("3 -> 4 -> 5", testGraph.BFS(three, five));
	}

	@Test
	public void print() {
		WeightedDirectedGraph testGraph = new WeightedDirectedGraph();
		Vertex one = new Vertex(1);
		Vertex two = new Vertex(2);
		Vertex three = new Vertex(3);
		Vertex four = new Vertex(4);
		Vertex five = new Vertex(5);
		testGraph.addVertex(one);
		testGraph.addVertex(two);
		testGraph.addVertex(three);
		testGraph.addVertex(four);
		testGraph.addVertex(five);
		testGraph.addEdge(one, two, 1);
		testGraph.addEdge(three, four, 1);
		testGraph.addEdge(four, five, 1);
		testGraph.addEdge(three, one, 3);
		System.out.println(testGraph.toString());
	}

}