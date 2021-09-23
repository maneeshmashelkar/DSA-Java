package queueByArray;

public class CircularQueue {

	public int[] arr;
	public int beginningOfQueue;
	public int topOfQueue;
	public int size;
	
	//Initialization of Queue
	public CircularQueue(int size) {
		this.arr = new int[size];
		this.beginningOfQueue = -1;
		this.topOfQueue = -1;
		this.size = size;
	}
	
	// isFull method 
	public boolean isFull() {
		if(topOfQueue+1 == beginningOfQueue) {
			return true;
		}else if(beginningOfQueue == 0 && topOfQueue+1==size) {
			return true;
		}else {
			return false;
		}
	}
	
	//isEmpty method 
	public boolean isEmpty() {
		if(topOfQueue == -1) {
			return true;
		}else {
			return false;
		}
	}
	
	//enQueue method
	public void enQueue(int value) {
		if(isFull()) {
			System.out.println("CQ is Full");
		}else if(isEmpty()){
			beginningOfQueue =0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println(value+ " is inserted in CQ");
		}else {
			if(topOfQueue+1 == size){
				topOfQueue =0;
			}else {
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println(value+ " is inserted in CQ");
		}
	}
	
	//deQueue method
	public int deQueue() {
		if(isEmpty()) {
			System.out.println("the CQ is empty");
			return -1;
		}else {
			int result= arr[beginningOfQueue];
			arr[beginningOfQueue] = 0;
			if(beginningOfQueue == topOfQueue) {
				beginningOfQueue = topOfQueue = -1;
			}else if(beginningOfQueue+1 == size) {
				beginningOfQueue = 0;
			}else {
				beginningOfQueue++;
			}
			return result;
		}
	}
	
	// peek method
	public int peek() {
		if(isEmpty()) {
			System.out.println("the CQ is empty");
			return -1;
		}else {
			return arr[beginningOfQueue];
		}
	}
	
	//delete method
	public void delete() {
		arr= null;
		System.out.println("the CQ is deleted!");
	}
	
	public static void main(String[] args) {
		CircularQueue cd =new  CircularQueue(3);
		
		System.out.println(cd.isEmpty());
		System.out.println(cd.isFull());
		
		cd.enQueue(1);
		cd.enQueue(2);
		cd.enQueue(3);
		cd.enQueue(4);
		
		System.out.println(cd.deQueue());
		System.out.println(cd.deQueue());
		
		System.out.println(cd.peek());
		System.out.println(cd.peek());
		
		cd.delete();
		
		System.out.println(cd.isEmpty());
		System.out.println(cd.isFull());
		
	}

}
