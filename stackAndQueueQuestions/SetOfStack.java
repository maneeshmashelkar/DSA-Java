package stackAndQueueQuestions;

import java.util.EmptyStackException;
import java.util.ArrayList;

// StackOfPlate problem

class StackNode{
	public StackNode below;
	public StackNode above;
	public int value;
	
	public StackNode(int value) {
		this.value = value;
	}
}

class Stack {

	private int capacity;
	public StackNode top;
	public StackNode bottom;
	public int size=0;
	
	public Stack(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull() {
		return capacity == size;
	}
	
	public void join(StackNode above,StackNode below) {
		if(above != null) above.below = below;
		if(below != null) below.above = above;
	}
	
	public boolean push(int value) {
		if(size >= capacity) return false;
		size++;
		StackNode newNode = new StackNode(value);
		if(size ==1) bottom = newNode;
		join(newNode, top);
		top = newNode;
		return true;
	}
	
	public int pop() {
		if(top == null) throw new EmptyStackException();
		int value = top.value;
		top = top.below;
		size--;
		return value;
	}
	
	public int removeBottom() {
		StackNode b =bottom;
		bottom = bottom.above;
		if(bottom != null) bottom.below = null;
		size--;
		return b.value;
	}
	
	

}



public class SetOfStack{
	
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStack(int capacity) {
		this.capacity = capacity;
	}
	
	public Stack getLastStack() {
		if(stacks.size() ==0) {
			return null;
		}
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int value) {
		Stack last =getLastStack();
		if((last != null) && (!last.isFull())) {
			last.push(value);
		}else {
			Stack stack = new Stack(capacity);
			stack.push(value);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		if(last == null) throw new EmptyStackException();
		int result = last.pop();
		if(last.size == 0) {
			stacks.remove(stacks.size()-1);
		}
		return result;
	}
	
	public int leftShift(int index,boolean removeTop) {
		Stack stack = stacks.get(index);
		int removeItem;
		if(removeTop) removeItem = stack.pop();
		else removeItem = stack.removeBottom();
		
		if(stack.size == 0) {
			stacks.remove(index);
		}else if(stacks.size() > index +1) {
			int v = leftShift(index+1, false);
			stack.push(v);
		}
		return removeItem;
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	
	
	public static void main(String[] args) {
		
		SetOfStack s = new SetOfStack(3);
		
		s.push(5);
		s.push(3);
		s.push(4);
		s.push(2);
		s.push(7);
		
		System.out.println(s.popAt(0));
		System.out.println(s.popAt(0));
	}
}
