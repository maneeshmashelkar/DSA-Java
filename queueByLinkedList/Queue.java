package queueByLinkedList;

public class Queue {

	LinkedList list;
	
	// Initialization of queue
	public Queue() {
		list = new LinkedList();
		System.out.println("Queue is created");
	}
	
	//isEmpty method
	public boolean isEmpty() {
		if(list.head == null) {
			return true;
		}else {
			return false;
		}
	}
	
	//enQueue method 
	public void enQueue(int value) {
		list.insertionInLinkedList(value, list.size);
		System.out.println(value+" is inserted in Queue");
	}
	
	//deQueue method
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}else {
			int value = list.head.value;
			list.deleteInSLL(0);
			return value;
		}
	}

	//peek method
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}else {
			return list.head.value;
		}
	}
	
	//delete method
	public void delete() {
		list.head=null;
		list.tail=null;
		System.out.println("Queue is deleted!");
	}

	public static void main(String arg[]) {
		
		Queue q = new Queue();
		System.out.println(q.isEmpty());
		
		q.enQueue(5);
		q.enQueue(4);
		q.enQueue(6);
		q.enQueue(7);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
		System.out.println(q.peek());
		System.out.println(q.peek());
		
		q.delete();
		
		System.out.println(q.isEmpty());
	}

}

