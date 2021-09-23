package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	BinaryNode root;

	public BinarySearchTree() {
		root = null;
		System.out.println("BST is created");
	}

	// insert method
	private BinaryNode insert(BinaryNode currNode, int value) {
		if (currNode == null) {
			BinaryNode node = new BinaryNode();
			node.value = value;
			System.out.println(value + " inserted in Tree");
			return node;
		} else if (value <= currNode.value) {
			currNode.left = insert(currNode.left, value);
			return currNode;
		} else {
			currNode.right = insert(currNode.right, value);
			return currNode;
		}
	}

	public void insert(int value) {
		root = insert(root, value);

	}

	// preOrder Traversal
	public void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// inOrder traversal
	public void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	// postOrder traversal
	public void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	// levelOrder traversal
	public void levelOrder() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.poll();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
	}
	
	//search method
	public BinaryNode search(BinaryNode node,int value) {
		if(node == null) {
			System.out.println(value+" not found in BST");
			return null;
		}else if(node.value == value) {
			System.out.println(value + " found in BST");
			return node;
		}else if(node.value > value) {
			return search(node.left, value);
		}else {
			return search(node.right, value);
		}
	}
	
	// minimum node
	public static BinaryNode MinNode(BinaryNode node) {
		if(node.left == null) {
			return node;
		}
		return MinNode(node.left);
	}
	
	// delete node
	public BinaryNode delete(BinaryNode node,int value) {
		if(node ==null) {
			System.out.println(value+" is not found in BST");
			return null;
		}
		if(value < node.value) {
			node.left =delete(node.left,value);
		}else if(value > node.value) {
			node.right = delete(node.right,value);
		}else {
			if(node.left !=null && node.right != null) {
				BinaryNode temp=node;
				BinaryNode minNodeInRight = MinNode(temp.right);
				node.value = minNodeInRight.value;
				node.right = delete(node.right, minNodeInRight.value);
				
			}else if(node.left != null) {
				node = node.left;
			}else if(node.right != null) {
				node = node.right;
			}else {
				node = null;
			}
		}
		return node;
	}
	
	public void deleteBST() {
		root = null;
		System.out.println("BST is deleted!");
	}
	

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(70);
		bst.insert(50);
		bst.insert(90);
		bst.insert(30);
		bst.insert(60);
		bst.insert(80);
		bst.insert(100);
		bst.insert(20);
		bst.insert(40);

//		bst.preOrder(bst.root);
//		System.out.println("");
//		bst.inOrder(bst.root);
//		System.out.println("");
//		bst.postOrder(bst.root);
		
		bst.levelOrder();
		System.out.println("");
		
//		bst.search(bst.root, 100);
		
//		bst.delete(bst.root,40);
//		bst.delete(bst.root,30);
//		bst.delete(bst.root,70);
		
//		bst.deleteBST();
		
		bst.levelOrder();
	}

}
