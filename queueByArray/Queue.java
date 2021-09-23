package queueByArray;

public class Queue {

	public int[] arr;
	public int beginningOfQueue;
	public int topOfQueue;

	// Initialization of queue
	public Queue(int size) {
		this.arr = new int[size];
		this.beginningOfQueue = -1;
		this.topOfQueue = -1;
		System.out.println("Queue is created with size of : " + size);
	}

	// isFull method
	public boolean isFull() {
		if (topOfQueue == arr.length-1) {
			return true;
		} else {
			return false;
		}
	}

	// isEmpty method
	public boolean isEmpty() {
		if ((beginningOfQueue == arr.length) || (beginningOfQueue == -1)) {
			return true;
		} else {
			return false;
		}
	}
	
	// enqueue method
	public void enQueue(int value) {
		if(isFull()) {
			System.out.println("Queue is full");
			return;
		}else if(isEmpty()) {
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue]= value;
			System.out.println(value + " is inserted in Queue");
		}else{
			topOfQueue++;
			arr[topOfQueue]= value;
			System.out.println(value + " is inserted in Queue");
		}
	}
	
	// dequeue method
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}else {
			int value = arr[beginningOfQueue];
			beginningOfQueue++;
			if(beginningOfQueue > topOfQueue) {
				beginningOfQueue = topOfQueue =  -1;
			}
			return value;
		}
	}
	
	// peek method
	public int peek() {
		if(!isEmpty()) {
			return arr[beginningOfQueue];
		}else {
			System.out.println("Queue is empty");
			return -1;
		}
	}
	
	// delete method;
	public void delete() {
		arr = null;
		System.out.println("Queue is deleted!");
	}

	public static void main(String[] args) {
		
		Queue q = new Queue(4);
		
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.enQueue(5);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
		System.out.println(q.peek());
		System.out.println(q.peek());
		
		q.delete();
		
		System.out.println(q.isEmpty());
		
	}

}
