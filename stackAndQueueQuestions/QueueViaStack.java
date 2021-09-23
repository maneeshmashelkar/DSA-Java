package stackAndQueueQuestions;

import java.util.Stack;

public class QueueViaStack {

	Stack<Integer> stackNewest,stackOldest;
	
	public QueueViaStack() {
		stackNewest = new Stack<>();
		stackOldest = new Stack<>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void enqueue(int value) {
		stackNewest.push(value);
	}
	
	private void shiftStack() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				int poopedOut = stackNewest.pop();
				stackOldest.push(poopedOut);
			}
		}
	}
	
	public int dequeue() {
		shiftStack();
		return stackOldest.pop();
	}
	
	public int peek() {
		shiftStack();
		return stackOldest.peek();
	}
	
	
	public static void main(String[] args) {
		QueueViaStack q =new QueueViaStack();
		
		q.enqueue(5);
		q.enqueue(3);
		q.enqueue(8);
		
		System.out.println(q.dequeue());
		
		q.enqueue(2);
		q.enqueue(7);
		
		System.out.println(q.dequeue());
	}

}
