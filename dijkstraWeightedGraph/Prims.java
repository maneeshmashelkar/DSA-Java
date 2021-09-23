package dijkstraWeightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {

	ArrayList<WeightedNode> nodeList = new ArrayList<>();

	public Prims(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	public void addUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		WeightedNode first = nodeList.get(firstIndex);
		WeightedNode second = nodeList.get(secondIndex);
		first.neighbors.add(second);
		second.neighbors.add(first);
		first.weightMap.put(second, weight);
		second.weightMap.put(first, weight);
	}

	void prims(WeightedNode node) {
		for (int i = 0; i < nodeList.size(); i++) {
			nodeList.get(i).distance = Integer.MAX_VALUE;
		}

		node.distance = 0;

		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			WeightedNode currentNode = queue.remove();
			for (WeightedNode neighbor : currentNode.neighbors) {
				if (queue.contains(neighbor)) {
					if (neighbor.distance > currentNode.weightMap.get(neighbor)) {
						neighbor.distance = currentNode.weightMap.get(neighbor);
						neighbor.parent = currentNode;
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}

		int cost = 0;
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.println(
					"Node " + nodeToCheck + ", key " + nodeToCheck.distance + " Parent: " + nodeToCheck.parent);
			cost = cost + nodeToCheck.distance;
		}
		System.out.println("\n Totol cost of MST: " + cost);
	}

	public static void main(String[] args) {

		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		nodeList.add(new WeightedNode("A"));
		nodeList.add(new WeightedNode("B"));
		nodeList.add(new WeightedNode("C"));
		nodeList.add(new WeightedNode("D"));
		nodeList.add(new WeightedNode("E"));

		Prims graph = new Prims(nodeList);
		graph.addUndirectedEdge(0, 1, 5);
		graph.addUndirectedEdge(0, 2, 13);
		graph.addUndirectedEdge(0, 4, 15);
		graph.addUndirectedEdge(1, 2, 10);
		graph.addUndirectedEdge(1, 3, 8);
		graph.addUndirectedEdge(2, 3, 6);
		graph.addUndirectedEdge(2, 4, 20);

		System.out.println("Running Prims Algo on the graph: ");
		graph.prims(nodeList.get(4));
	}

}
