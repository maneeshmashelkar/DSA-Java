package stackByArray;

public class Stack {

	public int[] arr;
	public int topOfStack;
	
	// create stack
	public Stack(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("The Stack is created with size " + size);
	}
	
	// check is stack is empty
	public boolean isEmpty() {
		if(topOfStack == -1) {
			return true;
		}else {
			return false;
		}
	}
	
	// check is stack is full
	public boolean isFull() {
		if(topOfStack == arr.length -1) {
			System.out.println("Stack is Full");
			return true;
		}else {
			return false;
		}
	}
	
	// push method
	public void push(int value) {
		if(this.isFull()){
			return;
		}else {
			this.arr[topOfStack+1] = value;
			topOfStack++;
			System.out.println(value +" is inserted!");
		}
	}
	
	// pop method
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		}else {
			int topValue = arr[topOfStack];
			topOfStack--;
			return topValue;
		}
	}
	
	// peek method
	public int peek() {
		if(this.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}else {
			return arr[topOfStack];
		}
	}
	
	// delete method
	public void delete() {
		this.arr = null;
		System.out.println("Stack is deleted");
	}
	
	
	public static void main(String[] args) {
		Stack s = new Stack(4);
		
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
