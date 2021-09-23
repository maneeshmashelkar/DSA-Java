package graphAdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjacencyList {

	public ArrayList<GraphNode> node = new ArrayList<>();

	public GraphAdjacencyList(ArrayList<GraphNode> node) {
		this.node = node;
	}

	public void addUnDirectNode(int i, int j) {
		GraphNode first = node.get(i);
		GraphNode second = node.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
	}

	public String print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < node.size(); i++) {
			sb.append(node.get(i).name + ": ");
			for (int j = 0; j < node.get(i).neighbors.size(); j++) {
				sb.append(node.get(i).neighbors.get(j).name);
				if (node.get(i).neighbors.size() - 1 > j) {
					sb.append(" -> ");
				}

			}
			sb.append("\n");
		}
		return sb.toString();
	}

	// BFS internally
	private void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode present = queue.remove(0);
			present.isVisited = true;
			System.out.print(present.name + " ");
			for (GraphNode neighbor : present.neighbors) {
				if (!neighbor.isVisited) {
					queue.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}

	// BFS
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
			for (GraphNode neighbor : present.neighbors) {
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
		GraphNode first = node.get(i);
		GraphNode second = node.get(j);
		first.neighbors.add(second);
	}

	private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor : node.neighbors) {
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
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.print("Printing path for node " + currentNode.name + ": ");
			pathPrint(currentNode);
			System.out.println();
			for (GraphNode neighbor : currentNode.neighbors) {
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
//		node.add(new GraphNode("B", 1));
//		node.add(new GraphNode("C", 2));
//		node.add(new GraphNode("D", 3));
//		node.add(new GraphNode("E", 4));
//
//		GraphAdjacencyList g = new GraphAdjacencyList(node);
//		g.addUnDirectNode(0, 1);
//		g.addUnDirectNode(0, 2);
//		g.addUnDirectNode(0, 3);
//		g.addUnDirectNode(1, 4);
//		g.addUnDirectNode(2, 3);
//		g.addUnDirectNode(3, 4);
//
//		System.out.println(g.print().toString());

//		g.BFS();

//		g.DFS();

		// ---------------------------------------------------------

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
//		GraphAdjacencyList g = new GraphAdjacencyList(node);
//		g.addDirectedEdge(0, 2);
//		g.addDirectedEdge(1, 2);
//		g.addDirectedEdge(1, 3);
//		g.addDirectedEdge(2, 4);
//		g.addDirectedEdge(4, 7);
//		g.addDirectedEdge(3, 5);
//		g.addDirectedEdge(5, 6);
//		g.addDirectedEdge(4, 5);
//		
//		System.out.println(g.print());
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

		GraphAdjacencyList g = new GraphAdjacencyList(node);
		g.addUnDirectNode(0, 1);
		g.addUnDirectNode(0, 2);
		g.addUnDirectNode(1, 3);
		g.addUnDirectNode(1, 6);
		g.addUnDirectNode(2, 3);
		g.addUnDirectNode(2, 4);
		g.addUnDirectNode(3, 5);
		g.addUnDirectNode(4, 5);
		g.addUnDirectNode(5, 6);
		
		g.BFSForSSSPP(node.get(0));
	}

}
