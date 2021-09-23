package avlTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {

	public BinaryNode root;

	AVL() {
		root = null;
	}

	// preOrder
	public void preOrder(BinaryNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// inOrder
	public void inOrder(BinaryNode node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	// postOrder
	public void postOrder(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	// levelOrder
	public void levelOrder() {
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

	// search
	public BinaryNode search(BinaryNode node, int value) {
		if (node == null) {
			System.out.println(value + " not found in AVL tree");
			return null;
		} else if (value == node.value) {
			System.out.println(value + " found in AVL Tree");
			return node;
		} else if (value < node.value) {
			return search(node.left, value);
		} else {
			return search(node.right, value);
		}
	}

	// getHeight
	public int getHeight(BinaryNode node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	// rotateRight
	public BinaryNode rotateRight(BinaryNode disbalanceNode) {
		BinaryNode newRoot = disbalanceNode.left;
		disbalanceNode.left = disbalanceNode.left.right;
		newRoot.right = disbalanceNode;
		disbalanceNode.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
	}

	// rotateLeft
	public BinaryNode rotateLeft(BinaryNode disbalanceNode) {
		BinaryNode newRoot = disbalanceNode.right;
		disbalanceNode.right = disbalanceNode.right.left;
		newRoot.left = disbalanceNode;
		disbalanceNode.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
	}

	//getBalance
	public int getBalance(BinaryNode node) {
		if(node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}
	
	// insertNode
	private BinaryNode insertNode(BinaryNode node,int value) {
		if(node == null) {
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			newNode.height =1;
			return newNode;
		}else if(value < node.value) {
			node.left = insertNode(node.left, value);
		}else if(value > node.value) {
			node.right = insertNode(node.right, value);
		}
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		int balance = getBalance(node);
		
		if(balance > 1 && value < node.left.value) {
			return rotateRight(node);
		}
		
		if(balance > 1 && value > node.right.value) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		
		if(balance < -1 && value > node.right.value) {
			return rotateLeft(node);
		}
		
		if(balance < -1 && value < node.right.value) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		
		return node;
	}
	
	//insert node
	public void insert(int value) {
		root = insertNode(root, value);
	}
	
	//minimum node
	public BinaryNode minNode(BinaryNode root) {
		if(root.left == null) {
			return root;
		}
		return minNode(root.left);
	}
	
	// delete Node
	public BinaryNode deleteNode(BinaryNode node, int value) {
		if(node == null) {
			System.out.println(" Node Not Found in AVL tree");
			return node;
		}else if(value < node.value) {
			node.left = deleteNode(node.left, value);
		}else if(value > node.value) {
			node.right = deleteNode(node.right, value);
		}else {
			if(node.left != null && node.right != null) {
				BinaryNode temp = node;
				BinaryNode minNodeOfRight  = minNode(temp.right);
				node.value = minNodeOfRight.value;
				node.right = deleteNode(node.right, minNodeOfRight.value);
			}else if(node.left != null) {
				node = node.left;
			}else if(node.right != null) {
				node = node.right;
			}else {
				node =null;
			}
		}
		
		
		int balance  = getBalance(node);
		
		if(balance > 1 && getBalance(node.left)>=0) {
			return rotateRight(node);
		}
		
		if(balance > 1 && getBalance(node.left)< 0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		
		if(balance < -1 && getBalance(node.right)<=0) {
			return rotateLeft(node);
		}
		
		if(balance < -1 && getBalance(node.right)> 0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		
		return node;
		
	}
	
	//delete
	public void delete(int value) {
		root = deleteNode(root, value);
	}
	
	//delete tree
	public void deleteTree() {
		root=null;
		System.out.println("AVL tree is deleted!");
	}

	public static void main(String[] args) {

		AVL avl = new AVL();
		
		avl.insert(5);
		avl.insert(10);
		avl.insert(15);
		avl.insert(20);
		
		avl.levelOrder();
		System.out.println("");
		avl.delete(5);
//		avl.deleteTree();
		avl.levelOrder();

	}

}
