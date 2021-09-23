package stackByLinkedList;

public class Stack {

	LinkedList ll;
	
	// create stack
	public Stack() {
		ll = new LinkedList();
	}
	
	// push method
	public void push(int value) {
		ll.insertionInLinkedList(value, 0);
		System.out.println(value + " is inserted");
	}
	
	// isEmpty method
	public boolean isEmpty() {
		if(ll.head == null) {
			System.out.println("Stack is empty");
			return true;
		}else {
			return false;
		}
	}
	
	//pop method
	public int pop() {
		if(isEmpty()) {
			return -1;
		}else {
			int value = ll.head.value;
			ll.deleteInSLL(0);
			return value;
		}
	}
	
	//peek method
	public int peek() {
		if(isEmpty()) {
			return -1;
		}else {
			return ll.head.value;
		}
	}
	
	//delete method
	public void delete() {
		ll.head = null;
		System.out.println("Stack is deleted");
	}
	
	
	
	
	public static void main(String[] args) {
		
		Stack s = new Stack();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		
		System.out.println(s.peek());
		System.out.println(s.peek());
		
		s.delete();
		
		System.out.println(s.peek());
	}

}
