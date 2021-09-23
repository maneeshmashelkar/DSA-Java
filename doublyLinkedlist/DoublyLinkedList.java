package doublyLinkedlist;

public class DoublyLinkedList {

	public Node head;
	public Node tail;
	public int size;

	// create in dLL
	public Node createDLL(int nodeValue) {
		head = new Node();
		Node node = new Node();
		node.value = nodeValue;
		node.next = null;
		node.prev = null;
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	//insert in dLL
	public void insertDLL(int  nodeValue,int location) {
		Node node = new Node();
		node.value = nodeValue;
		
		if(head ==null) {
			System.out.println("dLL does not exist!");
			return;
		}else if(location == 0) {
			head.prev = node;
			node.next = head;
			node.prev = null;
			head = node;
			size++;
		}else if(location >= size) {
			node.next=null;
			tail.next = node;
			node.prev = tail;
			tail = node;
			size++;
		}else {
			Node tempNode= head;
			for(int i=0;i<location-1;i++) {
				tempNode = tempNode.next;
			}
			
			node.next = tempNode.next;
			node.prev = tempNode;
			tempNode.next.prev = node;
			tempNode.next = node;
			size++;
		}
		
		
	}
	
	//traverse dLL
	public void traverseDLL() {
		if(head==null) {
			System.out.println("dLL does not exist!");
			return;
		}else {
			Node tempNode = head ;
			for(int i=0;i<size;i++) {
				System.out.print(tempNode.value);
				if(i < size-1) {
					System.out.print(" - ");
				}
				tempNode = tempNode.next;
			}
			System.out.println("");
		}
	}
	
	// traverse reverse on dLL
	
	public void reverseTDLL() {
		if(tail==null) {
			System.out.println("dLL does not exist!");
			return;
		}else {
			Node tempNode = tail;
			for(int i=size-1;i>=0;i--) {
				System.out.print(tempNode.value);
				if(i > 0) {
					System.out.print(" - ");
				}
				tempNode = tempNode.prev;
			}
			System.out.println("");
		}
	}
	
	// search in dLL
	public void searchDLL(int nodeValue) {
		
		if(head == null) {
			System.out.println("dLL does not exist!");
		}
		
		Node tempNode = head;
		for(int i=0;i<size;i++) {
			if(nodeValue == tempNode.value) {
				System.out.println("Value fount at index "+i);
				return;
			}
			tempNode = tempNode.next;
		}
		System.out.println("Value not found");
	}
	
	//deletion in dLL
	public void deleteDLL(int location) {
		if(head==null) {
			System.out.println("dLL does not exist!");
			return;
		}else if(location < 0) {
			System.out.println("only positive index");
			return;
		}
		
		if(location ==0) {
			if(size == 1) {
				head=null;
				tail=null;
				size--;
				return;
			}
			head = head.next;
			head.prev = null;
			size--;
		}else if(location >= size-1) {
			if(size==1) {
				head=null;
				tail=null;
				size--;
				return;
			}
			tail = tail.prev;
			tail.next = null;
			size--;
		}else {
			Node tempNode = head;
			for(int i=0;i<location-1;i++) {
				tempNode = tempNode.next;
			}
			
			tempNode.next = tempNode.next.next;
			tempNode.next.prev = tempNode;
			size--;
		}
	}
	
	//clear dLL
	public void clearDLL() {
		if(head ==null) {
			System.out.println("dLL does not exist!");
			return;
		}
		
		Node tempNode=head;
		for(int i=0;i<size;i++) {
			tempNode.prev = null;
			tempNode = tempNode.next;
		}
		head=null;
		tail = null;
		size=0;
		System.out.println("Cleared dLL");
	}

	public static void main(String[] args) {
		
		DoublyLinkedList dLL = new DoublyLinkedList();
		
		dLL.createDLL(5);
		dLL.insertDLL(4, 1);
		dLL.insertDLL(3, 0);
		dLL.insertDLL(7, 7);
		dLL.insertDLL(8, 2);
		
//		System.out.println(dLL.head.next.next.value);
		dLL.traverseDLL();
//		dLL.reverseTDLL();
		
//		dLL.searchDLL(8);
		
//		dLL.deleteDLL(3);
		
		dLL.clearDLL();
		
		dLL.traverseDLL();
	}

}
