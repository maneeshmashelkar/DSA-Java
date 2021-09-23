package dijkstraWeightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public WeightedGraph(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	void dijkstra(WeightedNode node) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
		node.distance = 0;
		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
			WeightedNode currenNode = queue.remove();
			for (WeightedNode neighbor : currenNode.neighbors) {
				if (queue.contains(neighbor)) {
					if (neighbor.distance > currenNode.distance + currenNode.weightMap.get(neighbor)) {
						neighbor.distance = (currenNode.distance + currenNode.weightMap.get(neighbor));
						neighbor.parent = currenNode;
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}

		for (WeightedNode nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}

	}

	public void pathPrint(WeightedNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, d);
	}
	
	//bellman ford algorithm
	
	public void bellmanFord(WeightedNode source) {
		source.distance =0 ;
		for(int i=0;i<nodeList.size();i++) {
			for(WeightedNode curreNode : nodeList) {
				for(WeightedNode neighbor : curreNode.neighbors) {
					if(neighbor.distance > curreNode.distance + curreNode.weightMap.get(neighbor)) {
						neighbor.distance = (curreNode.distance + curreNode.weightMap.get(neighbor));
						neighbor.parent = curreNode;
					}
				}
			}
		}
		System.out.println("checking for negative cycle..");
		for(WeightedNode curreNode : nodeList) {
			for(WeightedNode neighbor : curreNode.neighbors) {
				if(neighbor.distance > curreNode.distance + curreNode.weightMap.get(neighbor)) {
					System.out.println("negative cycle found: \n");
					System.out.println("vertex name: "+ neighbor.name);
					System.out.println("Old coast: " + neighbor.distance);
					int newDistance= (curreNode.distance + curreNode.weightMap.get(neighbor));
					System.out.println("new cost: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative cycle not found");
		
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}
	
	// floydWarshall algorithm
	
	public void floydWarshall() {
		int size = nodeList.size();
		int v[][] = new int[size][size];
		
		for(int i=0;i<size;i++) {
			WeightedNode first = nodeList.get(i);
			for(int j=0;j<size;j++) {
				WeightedNode second = nodeList.get(j);
				if(i==j) {
					v[i][j] =0;
				}else if(first.weightMap.containsKey(second)) {
					v[i][j] = first.weightMap.get(second);
				}else {
					v[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}
		
		for(int k=0;k<nodeList.size();k++) {
			for(int i=0;i<nodeList.size();i++) {
				for(int j=0;j<nodeList.size();j++) {
					if(v[i][j] > v[i][k] + v[k][j]) {
						v[i][j] = v[i][k] + v[k][j];
					}
				}
			}
		}
		
		for(int i=0;i<nodeList.size();i++) {
			System.out.print("Printing distance list for node " +nodeList.get(i)+": ");
			for(int j=0;j<nodeList.size();j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ArrayList<WeightedNode> nodeList = new ArrayList<>();
//		nodeList.add(new WeightedNode("A", 0));
//		nodeList.add(new WeightedNode("B", 2));
//		nodeList.add(new WeightedNode("C", 3));
//		nodeList.add(new WeightedNode("D", 4));
//		nodeList.add(new WeightedNode("E", 5));
//		nodeList.add(new WeightedNode("F", 6));
//		nodeList.add(new WeightedNode("G", 7));
//		
//		
//		WeightedGraph newGraph = new WeightedGraph(nodeList);
//		newGraph.addWeightedEdge(0, 1, 2);
//		newGraph.addWeightedEdge(0, 2, 5);
//		newGraph.addWeightedEdge(1, 2, 6);
//		newGraph.addWeightedEdge(1, 3, 1);
//		newGraph.addWeightedEdge(1, 4, 3);
//		newGraph.addWeightedEdge(2, 5, 8);
//		newGraph.addWeightedEdge(2, 4, 4);
//		newGraph.addWeightedEdge(4, 6, 9);
//		newGraph.addWeightedEdge(5, 6, 7);
		
//		System.out.println("Printing Dijkstra from source: A");
//		newGraph.dijkstra(nodeList.get(0));
		
//		System.out.println("Printing bellman ford from source: A");
//		newGraph.bellmanFord(nodeList.get(0));
		
		//---------------------------------------------------------------------------------------------------------------
		
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));
		
		WeightedGraph newGraph = new WeightedGraph(nodeList);
		newGraph.addWeightedEdge(0, 1, 8);
		newGraph.addWeightedEdge(0, 3, 1);
		newGraph.addWeightedEdge(1, 2, 1);
		newGraph.addWeightedEdge(2, 0, 4);
		newGraph.addWeightedEdge(3, 1, 2);
		newGraph.addWeightedEdge(3, 2, 9);
		
		System.out.println("Printing floyd warshall alogorithm form source A:");
		newGraph.floydWarshall();
		
	}

}
