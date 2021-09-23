package dijkstraWeightedGraph;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode> {
	public String name;
	public ArrayList<WeightedNode> neighbors = new ArrayList<>();
	public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public int distance;
	public int index;
	public WeightedNode parent;
	public DisjointSet set;

	public WeightedNode(String name, int index) {
		this.name = name;
		this.distance = Integer.MAX_VALUE;
		this.index = index;
	}
	
	public WeightedNode(String name) {
		this.name = name;
		this.distance = Integer.MAX_VALUE;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode o) {
		return this.distance - o.distance;
	}
}
