package tree;

import java.util.ArrayList;

public class TreeNode {

	String data;
	ArrayList<TreeNode> childrean;
	
	public TreeNode(String data) {
		this.data = data;
		this.childrean = new ArrayList<TreeNode>();
	}
	
	public void addChild(TreeNode node) {
		this.childrean.add(node);
	}
	
	public String print(int level) {
		String ret;
		ret = " ".repeat(level)+data+"\n";
		for(TreeNode node : childrean) {
			ret += node.print(level+1);
		}
		return ret;
	}
	
	
	public static void main(String[] args) {
		TreeNode drink = new TreeNode("drink");
		TreeNode hot = new TreeNode("hot");
		TreeNode cold = new TreeNode("cold");
		
		TreeNode tea = new TreeNode("tea");
		TreeNode coffee = new TreeNode("coffee");
		
		TreeNode wine = new TreeNode("wine");
		TreeNode beer = new TreeNode("beer");
		
		drink.addChild(hot);
		drink.addChild(cold);
		
		hot.addChild(tea);
		hot.addChild(coffee);
		
		cold.addChild(beer);
		cold.addChild(wine);
		
		System.out.println(drink.print(0));
	}

}
