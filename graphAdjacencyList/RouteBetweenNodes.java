package graphAdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;

public class RouteBetweenNodes {

	static ArrayList<GraphNode> nodeList = new ArrayList<>();
	
	public enum State{
		Unvisited,Visited,Visiting;
	}
	
	public RouteBetweenNodes(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addDirectedEdge(int i,int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second =  nodeList.get(j);
		first.neighbors.add(second);
	}
	
	
	
	public static boolean search(GraphNode start,GraphNode end) {
		LinkedList<GraphNode> q = new LinkedList<>();
		
		for(GraphNode node: nodeList) {
			node.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		GraphNode currentNode;
		while(!q.isEmpty()) {
			currentNode = q.removeFirst();
			if(currentNode != null) {
				for(GraphNode v : currentNode.neighbors) {
					if(v.state == State.Unvisited) {
						if(v == end) {
							return true;
						}else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				currentNode.state = State.Visited;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));
		nodeList.add(new GraphNode("F", 5));
		nodeList.add(new GraphNode("G", 6));
		nodeList.add(new GraphNode("H", 7));
		nodeList.add(new GraphNode("I", 8));
		nodeList.add(new GraphNode("J", 9));
		
		RouteBetweenNodes graph = new RouteBetweenNodes(nodeList);
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(0, 3);
		graph.addDirectedEdge(1, 9);
		graph.addDirectedEdge(2, 6);
		graph.addDirectedEdge(4, 0);
		graph.addDirectedEdge(4, 5);
		graph.addDirectedEdge(5, 8);
		graph.addDirectedEdge(6, 7);
		graph.addDirectedEdge(6, 3);
	
		boolean result =graph.search(nodeList.get(4), nodeList.get(1));
		System.out.println(result);
	}

}
