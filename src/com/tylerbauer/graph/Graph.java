package com.tylerbauer.graph;

public class Graph {
	private Vertex[] vertices;
	private Edge[][] edges;
	private int numVertices;

	public Graph() {
		this.numVertices = 0;
		this.vertices = new Vertex[10];
		this.edges = new Edge[10][10];
	}

	private void growVertices() {
		Vertex[] largerV = new Vertex[numVertices * 2];
		Edge[][] largerE = new Edge[numVertices * 2][numVertices * 2];

	}
}
