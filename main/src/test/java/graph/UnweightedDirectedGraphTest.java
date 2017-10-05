package graph;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class UnweightedDirectedGraphTest {

	@Test
	public void addVertex() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
		Vertex one = new Vertex(1);
		testGraph.addVertex(one);
		assertEquals(true, testGraph.containsVertex(one));
		assertEquals(false, testGraph.containsVertex(new Vertex(2)));
	}

	@Test
	public void removeVertex() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
		Vertex one = new Vertex(1);
		testGraph.addVertex(one);
		assertEquals(true, testGraph.containsVertex(one));
		testGraph.removeVertex(one);
		assertEquals(false, testGraph.containsVertex(one));
	}

	@Test
	public void addEdge() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
		Vertex test3 = new Vertex(3);
		Vertex test4 = new Vertex(4);
		testGraph.addVertex(test3);
		testGraph.addVertex(test4);
		assertEquals(false, testGraph.isEdge(test3, test4));
		testGraph.addEdge(test3, test4);
		assertEquals(true, testGraph.isEdge(test3, test4));
	}

	@Test
	public void removeEdge() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
		Vertex test3 = new Vertex(3);
		Vertex test4 = new Vertex(4);
		testGraph.addVertex(test3);
		testGraph.addVertex(test4);
		testGraph.addEdge(test3, test4);
		assertEquals(true, testGraph.isEdge(test3, test4));
		testGraph.removeEdge(test3, test4);
		assertEquals(false, testGraph.isEdge(test3, test4));
	}

	@Test
	public void isEdge() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
		Vertex test3 = new Vertex(3);
		Vertex test4 = new Vertex(4);
		testGraph.addVertex(test3);
		testGraph.addVertex(test4);
		assertEquals(false, testGraph.isEdge(test3, test4));
		testGraph.addEdge(test3, test4);
		assertEquals(true, testGraph.isEdge(test3, test4));
	}

	@Test
	public void BFS() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
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
		testGraph.addEdge(one, two);
		testGraph.addEdge(two, three);
		testGraph.addEdge(three, four);
		testGraph.addEdge(four, five);
		testGraph.addEdge(two, five);
		testGraph.addEdge(three, one);
		assertEquals("1 -> 2 -> 3 -> 4", testGraph.BFS(one, four));
	}

	@Test
	public void DFS() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
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
		testGraph.addEdge(one, two);
		testGraph.addEdge(three, four);
		testGraph.addEdge(four, five);
		testGraph.addEdge(three, one);
		assertEquals("3 -> 4 -> 5", testGraph.BFS(three, five));
	}

	@Test
	public void print() {
		UnweightedDirectedGraph testGraph = new UnweightedDirectedGraph();
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
		testGraph.addEdge(one, two);
		testGraph.addEdge(three, four);
		testGraph.addEdge(four, five);
		testGraph.addEdge(three, one);
		System.out.println(testGraph.toString());
	}

}