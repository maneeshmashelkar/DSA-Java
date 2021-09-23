package linkedlist;

public class CircularSinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	// Create circular singly linked list
	public Node createcSLL(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.value = nodeValue;
		node.next = node;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	// insertion in cSLL

	public void insertCSLL(int nodeValue, int location) {
		Node node = new Node();
		node.value = nodeValue;

		if (head == null) {
			createcSLL(nodeValue);
			return;
		} else if (location == 0) {
			node.next = head;
			head = node;
			tail.next =head;

		} else if (location >= size) {
			tail.next= head;
			tail.next = node;
			tail = node;

		} else {
			Node currentNode = head;
			for (int i = 0; i < location - 1; i++) {
				currentNode = currentNode.next;
			}

			node.next = currentNode.next;
			currentNode.next = node;

		}
		size++;
	}
	
	// traversal in cSLL
	
	public void travereCSLL() {
		
		if (head != null) {
			Node tempNode = head;
			for(int i=0;i<size;i++) {
				System.out.print(tempNode.value);
				if(i < size-1) {
					System.out.print(" -> ");
				}
				tempNode= tempNode.next;
			}
			System.out.println("");
		}else {
			System.out.println("\ncSLL does not exist!");
		}
	}
	
	// search in cSll
	
	public void searchCSLL(int nodeValue) {
		if(head != null) {
			Node tempNode = head;
			for(int i=0;i<size;i++) {
				if(tempNode.value == nodeValue) {
					System.out.println("Value found at " + i);
					return;
				}
				tempNode = tempNode.next;
			}
			System.out.println("Value does not exist in cSLL!");
		}else {
			System.out.println("cSLL does not exist!");
		}
	}
	
	// delete node in cSLL
	
	public void deleteCSLL(int location) {
		
		if(head == null) {
			System.out.println("cSLL does not exist!");
			return;
		}else if(location == 0) {
			head = head.next;
			tail.next =head;
			size--;
			if(size ==0) {
				head.next=null;
				head= null;
				tail=null;
			}
		}else if(location >= size) {
			Node tempNode = head;
			for(int i=0;i<size-1;i++ ) {
				tempNode = tempNode.next;
			}
			if(tempNode==head) {
				head.next=null;
				head=null;
				tail=null;
				size--;
				return;
			}
			tempNode.next = head;
			tail = tempNode;
			size--;
			
		}else {
			Node tempNode =head;
			for(int i=0;i<location-1;i++) {
				tempNode = tempNode.next;
			}
			
			tempNode.next =tempNode.next.next;
			size--;
		}
		
	}
	
	// Clear cSLL
	
	public void clearCSLL() {
		
		if(head == null) {
			System.out.println("cSll does not exist!");
		}else {
			head= null;
			tail.next = null;
			tail=null;
			System.out.println("cSLL Cleared");
		}
		
	}

	public static void main(String[] args) {
		CircularSinglyLinkedList cSLL = new CircularSinglyLinkedList();

		cSLL.createcSLL(5);
		cSLL.insertCSLL(3, 5);
		cSLL.insertCSLL(7, 1);
		cSLL.insertCSLL(9, 2);
		cSLL.insertCSLL(2, 0);

//		System.out.println(cSLL.head.value);
//		System.out.println(cSLL.head.next.next.value);
		
		cSLL.travereCSLL();
		
//		cSLL.searchCSLL(2);
		
//		cSLL.deleteCSLL(1);
		
//		cSLL.clearCSLL();
		
		cSLL.travereCSLL();
	}
}
