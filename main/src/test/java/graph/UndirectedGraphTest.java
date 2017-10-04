package graph;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class UndirectedGraphTest {
	@Test
	public void addVertex() {
		UndirectedGraph testGraph = new UndirectedGraph();
		testGraph.addVertex(new Vertex(3));
		assertEquals("3\n", testGraph.toString());
	}

	@Test
	public void removeVertex() {
		UndirectedGraph testGraph = new UndirectedGraph();
		Vertex testVertex = new Vertex(3);
		testGraph.addVertex(testVertex);
		assertEquals("3\n", testGraph.toString());
		testGraph.removeVertex(testVertex);
		assertEquals("", testGraph.toString());
	}

	@Test
	public void addEdge() {
		UndirectedGraph testGraph = new UndirectedGraph();
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
		UndirectedGraph testGraph = new UndirectedGraph();
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
		UndirectedGraph testGraph = new UndirectedGraph();
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
		UndirectedGraph testGraph = new UndirectedGraph();
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
		assertEquals("3 -> 4 -> 5", testGraph.BFS(three, five));
	}

	@Test
	public void DFS() {
		UndirectedGraph testGraph = new UndirectedGraph();
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

}