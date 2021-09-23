package graphAdjacencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//import graphAdjacencyList.GraphAdjacencyList;
import graphAdjacencyList.GraphNode;

public class GraphAdjacencyMatrix {

	ArrayList<GraphNode> node = new ArrayList<>();
	int[][] adjMat;

	public GraphAdjacencyMatrix(ArrayList<GraphNode> nodes) {
		this.node = nodes;
		adjMat = new int[nodes.size()][node.size()];
	}

	public void addUnDirectNodes(int i, int j) {
		adjMat[i][j] = 1;
		adjMat[j][i] = 1;
	}

	public void print() {
		System.out.print("   ");
		for (int i = 0; i < node.size(); i++) {
			System.out.print(node.get(i).name + " ");
		}
		System.out.println("");
		for (int i = 0; i < node.size(); i++) {
			System.out.print(node.get(i).name + ": ");
			for (int j : adjMat[i]) {
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}

	// get neighbor nodes
	private ArrayList<GraphNode> getNeighbor(GraphNode node) {
		ArrayList<GraphNode> neighbor = new ArrayList<>();
		int nodeIndex = node.index;
		for (int i = 0; i < adjMat.length; i++) {
			if (adjMat[nodeIndex][i] == 1) {
				neighbor.add(this.node.get(i));
			}
		}
		return neighbor;
	}

	// BFS internal
	private void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode present = queue.remove(0);
			present.isVisited = true;
			System.err.print(present.name + " ");
			ArrayList<GraphNode> neighbors = getNeighbor(present);

			for (GraphNode neighbor : neighbors) {
				if (!present.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	public void BFS() {
		for (GraphNode node : this.node) {
			if (!node.isVisited) {
				bfsVisit(node);
			}
		}
	}

	// DFS internally
	private void dfsVisit(GraphNode node) {
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			GraphNode present = stack.pop();
			present.isVisited = true;
			System.out.print(present.name + " ");
			ArrayList<GraphNode> neighbors = getNeighbor(present);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					stack.push(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	// DFS
	public void DFS() {
		for (GraphNode node : this.node) {
			if (!node.isVisited) {
				dfsVisit(node);
			}
		}
	}

	// Topological Sort
	public void addDirectedEdge(int i, int j) {
		adjMat[i][j] = 1;
	}

	private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		ArrayList<GraphNode> neighbors = getNeighbor(node);
		for (GraphNode neighbor : neighbors) {
			if (!neighbor.isVisited) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}

	public void topologicalSort() {
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode node : this.node) {
			if (!node.isVisited) {
				topologicalVisit(node, stack);
				;
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " ");
		}
	}

	// SSSPP

	private void pathPrint(GraphNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}

		System.out.print(node.name + " ");
	}

	public void BFSForSSSPP(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + " : ");
			pathPrint(currentNode);
			System.out.println();
			ArrayList<GraphNode> neighbors = getNeighbor(currentNode);
			for (GraphNode neighbor : neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
					neighbor.parent = currentNode;
				}
			}
		}
	}

	public static void main(String[] args) {

//		ArrayList<GraphNode> node = new ArrayList<GraphNode>();
//		node.add(new GraphNode("A", 0));
//		node.add(new GraphNode("B", 0));
//		node.add(new GraphNode("C", 0));
//		node.add(new GraphNode("D", 0));
//		node.add(new GraphNode("E", 0));
//
//		GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(node);
//		g.addUnDirectNodes(0, 1);
//		g.addUnDirectNodes(0, 2);
//		g.addUnDirectNodes(0, 3);
//		g.addUnDirectNodes(1, 4);
//		g.addUnDirectNodes(2, 3);
//		g.addUnDirectNodes(3, 4);
//
//		g.print();

//		g.BFS();

//		g.DFS();

		// ---------------------------------------------------------------

//		ArrayList<GraphNode> node = new ArrayList<GraphNode>();
//		node.add(new GraphNode("A", 0));
//		node.add(new GraphNode("B", 1));
//		node.add(new GraphNode("C", 2));
//		node.add(new GraphNode("D", 3));
//		node.add(new GraphNode("E", 4));
//		node.add(new GraphNode("F", 5));
//		node.add(new GraphNode("G", 6));
//		node.add(new GraphNode("H", 7));
//
//		GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(node);
//		g.addDirectedEdge(0, 2);
//		g.addDirectedEdge(1, 2);
//		g.addDirectedEdge(1, 3);
//		g.addDirectedEdge(2, 4);
//		g.addDirectedEdge(4, 7);
//		g.addDirectedEdge(3, 5);
//		g.addDirectedEdge(5, 6);
//		g.addDirectedEdge(4, 5);
//
//		g.print();
//
//		g.topologicalSort();

		// ---------------------------------------------------------

		ArrayList<GraphNode> node = new ArrayList<GraphNode>();
		node.add(new GraphNode("A", 0));
		node.add(new GraphNode("B", 1));
		node.add(new GraphNode("C", 2));
		node.add(new GraphNode("D", 3));
		node.add(new GraphNode("E", 4));
		node.add(new GraphNode("F", 5));
		node.add(new GraphNode("G", 6));

		GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(node);
		g.addUnDirectNodes(0, 1);
		g.addUnDirectNodes(0, 2);
		g.addUnDirectNodes(1, 3);
		g.addUnDirectNodes(1, 6);
		g.addUnDirectNodes(2, 3);
		g.addUnDirectNodes(2, 4);
		g.addUnDirectNodes(3, 5);
		g.addUnDirectNodes(4, 5);
		g.addUnDirectNodes(5, 6);

		g.BFSForSSSPP(node.get(0));

	}

}
