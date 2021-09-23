package linkedListQuestion;

public class LinkedList {
	public Node head;
	public Node tail;
	public int size;
	
	// create LL
	public Node createLL(int nodeValue) {
		Node node = new Node();
		node.value = nodeValue;
		node.next =null;
		head = node;
		tail= node;
		size = 1;
		return head;
	}
	
	// insert LL
	public void insertLL(int nodeValue) {
		if(head == null) {
			createLL(nodeValue);
			return;
		}
		
		Node node = new Node();
		node.value = nodeValue;
		tail.next = node;
		node.next =null;
		tail = node;
		size++;
	}
	
	// traversal LL
	public void traversalLL() {
		Node tempNode = head;
		for(int i=0;i<size;i++) {
			System.out.print(tempNode.value);
			if(i < size-1) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		ll.createLL(5);
		ll.insertLL(2);
		ll.insertLL(1);
		ll.insertLL(8);
		ll.insertLL(9);
		
		ll.traversalLL();
	}

}
