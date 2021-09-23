package dijkstraWeightedGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {

	ArrayList<WeightedNode> nodeList = new ArrayList<>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<>();
	
	public Kruskal(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addUndirectedEdge(int firstIndex,int secondIndex,int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
		WeightedNode first = edge.first;
		WeightedNode second = edge.second;
		first.neighbors.add(second);
		second.neighbors.add(first);
		first.weightMap.put(first, weight);
		second.weightMap.put(second, weight);
		edgeList.add(edge);
	}
	
	void kruskal() {
		DisjointSet.makeSet(nodeList);
		
		Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
		
			@Override
			public int compare(UndirectedEdge o1,UndirectedEdge o2) {
				return o1.weight - o2.weight;
			}
		
		}; 
		
		Collections.sort(edgeList,comparator);
		
		int cost = 0;
		for(UndirectedEdge edge : edgeList) {
			WeightedNode first = edge.first;
			WeightedNode second = edge.second;
			if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
				DisjointSet.union(first, second);
				cost += edge.weight;
				System.out.println("Taken: "+edge);
			}
		}
		System.out.println("\nTotal cost of MST: "+ cost);
	}
	
	
	public static void main(String[] args) {
		
		
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		nodeList.add(new WeightedNode("A"));
		nodeList.add(new WeightedNode("B"));
		nodeList.add(new WeightedNode("C"));
		nodeList.add(new WeightedNode("D"));
		nodeList.add(new WeightedNode("E"));
		
		Kruskal graph = new Kruskal(nodeList);
		graph.addUndirectedEdge(0, 1, 5);
		graph.addUndirectedEdge(0, 2, 13);
		graph.addUndirectedEdge(0, 4, 15);
		graph.addUndirectedEdge(1, 2, 10);
		graph.addUndirectedEdge(1, 3, 8);
		graph.addUndirectedEdge(2, 3, 6);
		graph.addUndirectedEdge(2, 4, 20);
		
		System.out.println("Running Kruskal Algo on the graph: ");
		graph.kruskal();
		
	}

}
