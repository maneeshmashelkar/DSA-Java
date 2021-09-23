package doublyLinkedlist;

public class CircularDoubleLinkedList {

	public Node head;
	public Node tail;
	public int size;

	// create cDLL
	public Node createCDLL(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.value = nodeValue;
		head = node;
		tail = node;
		node.next = node;
		node.prev = node;
		size = 1;
		return head;
	}

	// insert in cDLL
	public void insertCDLL(int nodeValue, int location) {
		if (head == null) {
			System.out.println("cDLL does not exist!");
			return;
		}

		Node node = new Node();
		node.value = nodeValue;

		if (location == 0) {
			head.prev = node;
			node.next = head;
			node.prev = tail;
			tail.next = node;
			head = node;
		} else if (location >= size) {
			tail.next = node;
			node.prev = tail;
			tail = node;
			head.prev = tail;
			tail.next = head;
		} else {
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}

			node.next = tempNode.next;
			node.prev = tempNode;
			tempNode.next = node;
			node.next.prev = node;
		}
		size++;
	}

	// traversal in cDLL
	public void traversalCDLL() {
		if (head == null) {
			System.out.println("cDLL does not exist!");
			return;
		}

		Node tempNode = head;
		for (int i = 0; i < size; i++) {
			System.out.print(tempNode.value);
			if (i < size-1) {
				System.out.print(" - ");
			}
			tempNode = tempNode.next;
		}
		System.out.println("");
	}

	// reverse traversal in cDLL
	public void reverseTCDLL() {
		if (head == null) {
			System.out.println("cDLL does not exist!");
			return;
		}

		Node tempNode = tail;
		for (int i = 0; i < size; i++) {
			System.out.print(tempNode.value);
			if (i < size - 1) {
				System.out.print(" - ");
			}
			tempNode = tempNode.prev;
		}
		System.out.println("");
	}

	// search in cDLL
	public boolean serachCDLL(int nodeValue) {
		if (head == null) {
			System.out.println("cDLL does not exist!");
			return false;
		}

		Node tempNode = head;
		for (int i = 0; i < size; i++) {
			if (tempNode.value == nodeValue) {
				System.out.println("value found at index " + i);
				return true;
			}
			tempNode = tempNode.next;
		}

		System.out.println("value not found");
		return false;
	}

	// delete cDLL

	public void deleteCDLL(int location) {
		if(head == null) {
			System.out.println("cDLL does not exist!");
			return;
		}
		
		if(location == 0) {
			if(size == 1) {
				head=null;
				tail=null;
				head.prev=null;
				tail.prev=null;
				size--;
				return;
			}
			head.next.prev = tail;
			tail.next = head.next;
			head = head.next;
			
//			head=head.next;
//			head.prev =tail;
//			tail.next=head;
		}else if(location >= size) {
			if(size == 1) {
				head=null;
				tail=null;
				head.prev=null;
				tail.prev=null;
				size--;
				return;
			}
			tail.prev.next = head;
			head.prev = tail.next;
			tail = tail.prev;
			
//			tail=tail.prev;
//			tail.next =head;
//			head.prev =tail;
			
		}else{
			Node tempNode = head;
			for(int i=0;i<location-1;i++) {
				tempNode= tempNode.next;
			}
			
			tempNode.next.next.prev  = tempNode;
			tempNode.next = tempNode.next.next;
		}
		size--;
	}
	
	//clear cDLL
	public void clearedCDLL() {
		if(head == null) {
			System.out.println("cDLL does not exist!");
			return;
		}
		
		Node tempNode=head;
		for(int i=0;i<size;i++) {
			tempNode.prev = null;
			tempNode=tempNode.next;
		}
		head = null;
		tail = null;
		size=0;
		System.out.println("cDLL Cleared");
	}

	public static void main(String[] args) {

		CircularDoubleLinkedList cDLL = new CircularDoubleLinkedList();

		cDLL.createCDLL(7);
		cDLL.insertCDLL(5, 0);
		cDLL.insertCDLL(3, 1);
		cDLL.insertCDLL(6, 2);
		cDLL.insertCDLL(8, 3);
		cDLL.insertCDLL(1, 2);

		cDLL.traversalCDLL();
//		cDLL.reverseTCDLL();

//		cDLL.serachCDLL(3);
		
		cDLL.deleteCDLL(9);
		
//		cDLL.clearedCDLL();
		
		cDLL.traversalCDLL();
		cDLL.reverseTCDLL();
	}

}
