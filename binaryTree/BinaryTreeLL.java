package binaryTree;

import java.util.LinkedList;

import java.util.Queue;

public class BinaryTreeLL {

	public BinaryNode root;

	public BinaryTreeLL() {
		this.root = null;
	}

	// preOrder traversal
	public void preOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	// inOrder Traversal
	public void inOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);
	}

	// postOrder traversal
	public void postOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}

	// levelOrder traversal
	public void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
	}

	// search method
	public void search(String value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.value == value) {
				System.out.println(value + " is found is Tree");
				return;
			} else {
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}
		}
		System.out.println(value + " is not found is Tree");
	}

	// insert method
	public void insert(String value) {
		BinaryNode node = new BinaryNode();
		node.value = value;
		if (root == null) {
			root = node;
			System.out.println("value inserted at root node");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.left == null) {
				presentNode.left = node;
				System.out.println("value inserted");
				break;
			} else if (presentNode.right == null) {
				presentNode.right = node;
				System.out.println("value inserted");
				break;
			} else {
				queue.add(presentNode.left);
				queue.add(presentNode.right);
			}
		}
	}

	// get deepest node
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		return presentNode;
	}

	// delete deepest node
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode prevNode, presentNode = null;
		while (!queue.isEmpty()) {
			prevNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.left == null) {
				prevNode.right = null;
				return;
			}
			if (presentNode.right == null) {
				presentNode.left = null;
				return;
			}
			queue.add(presentNode.left);
			queue.add(presentNode.right);

		}
	}
	
	//delete given node
	public void delete(String value) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode =  queue.remove();
			if(presentNode.value == value) {
				presentNode.value = getDeepestNode().value;
				deleteDeepestNode();
				System.out.println("node deleted");
				return;
			}else {
				if(presentNode.left != null) queue.add(presentNode.left);
				if(presentNode.right != null) queue.add(presentNode.right);
			}
		}
		System.out.println("Node does not exist!");
	}
	
	//delete binary tree
	 public void deleteTree() {
		 root = null;
		 System.out.println("\nbinary tree is deleted!");
	 }

	public static void main(String[] args) {

		BinaryTreeLL bTLL = new BinaryTreeLL();

//		BinaryNode n1 = new BinaryNode();
//		n1.value = "n1";
//		BinaryNode n2 = new BinaryNode();
//		n2.value = "n2";
//		BinaryNode n3 = new BinaryNode();
//		n3.value = "n3";
//		BinaryNode n4 = new BinaryNode();
//		n4.value = "n4";
//		BinaryNode n5 = new BinaryNode();
//		n5.value = "n5";
//		BinaryNode n6 = new BinaryNode();
//		n6.value = "n6";
//		BinaryNode n7 = new BinaryNode();
//		n7.value = "n7";
//		BinaryNode n8 = new BinaryNode();
//		n8.value = "n8";
//		BinaryNode n9 = new BinaryNode();
//		n9.value = "n9";
//
//		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//		n4.left = n8;
//		n4.right = n9;
//		n3.left = n6;
//		n3.right = n7;
//
//		bTLL.root = n1;

		bTLL.insert("n1");
		bTLL.insert("n2");
		bTLL.insert("n3");
		bTLL.insert("n4");
		bTLL.insert("n5");
		bTLL.insert("n6");
		bTLL.insert("n7");
		bTLL.insert("n8");
		bTLL.insert("n9");
		bTLL.insert("n10");
		bTLL.insert("n11");
		
//		bTLL.preOrderTraversal(bTLL.root);

//		bTLL.inOrderTraversal(bTLL.root);

//		bTLL.postOrderTraversal(bTLL.root);

//		bTLL.levelOrderTraversal();

//		bTLL.search("n1");
		
//		System.out.println(bTLL.getDeepestNode().value);
		
//		bTLL.deleteDeepestNode();
		
		bTLL.delete("n7");
		
		bTLL.levelOrderTraversal();
		
		bTLL.deleteTree();
	}

}
