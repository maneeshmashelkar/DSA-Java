package linkedlist;

public class SinglyLinkedList {

	public Node head;
	public Node tail;
	public int size;

	public Node createSinglyLinkedList(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.next = null;
		node.value = nodeValue;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	// insertion in linked list

	public void insertionInLinkedList(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;

		if (head == null) {
			createSinglyLinkedList(nodeValue);
			return;
		} else if (location == 0) {
			node.next = head;
			head = node;
			return;
		} else if (location >= size) {
			node.next = null;
			tail.next = node;
			tail = node;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			Node nextNode = tempNode.next;
			tempNode.next = node;
			node.next = nextNode;
		}
		size++;

	}

	// traversal sLL

	public void traversalSLL() {

		if (head == null) {
			System.out.println("SLL does not exist");
			return;
		}

		int index = 0;
		Node tempNode = head;
		System.out.print("head");
		while (index < size) {
			System.out.print(" -> " + tempNode.value);
			tempNode = tempNode.next;
			index++;
		}
		System.out.println("\n");
	}

	// search in SLL

	public void searchInSLL(int nodeValue) {
		if (head == null) {
			System.out.println("SLL does not exist");
			return;
		}
		int index = 0;
		Node tempNode = head;
		while (index < size) {
			if (tempNode.value == nodeValue) {
				System.out.println(index);
				return;
			}
			tempNode = tempNode.next;
			index++;
		}
		System.out.println(-1);

	}

	// deleting node in sLL

	public void deleteInSLL(int location) {
		if (head == null) {
			System.out.println("SLL does not exist");
			return;
		}

		if (location == 0) {
			head = head.next;
			size--;
			if (size == 0) {
				tail = null;
			}
		} else if (location >= size) {
			Node tempNode = head;
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.next;
			}
			if (tempNode == head) {
				tail = head = null;
				size--;
				return;
			}
			tempNode.next = null;
			tail = tempNode;
			size--;
		} else {
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			size--;
		}
	}
	
	//clear SLL
	
	public void clearSLL() {
		head=null;
		tail=null;
		System.out.println("SLL cleared");
	}

	public static void main(String[] args) {

		SinglyLinkedList sLL = new SinglyLinkedList();

		sLL.createSinglyLinkedList(5);
		sLL.insertionInLinkedList(6, 1);
		sLL.insertionInLinkedList(7, 2);
		sLL.insertionInLinkedList(8, 3);
		sLL.insertionInLinkedList(9, 2);
		sLL.insertionInLinkedList(10, 8);

		sLL.traversalSLL();

//		sLL.searchInSLL(10);
//		sLL.deleteInSLL(4);
		sLL.clearSLL();
		
		sLL.traversalSLL();
	}

}
