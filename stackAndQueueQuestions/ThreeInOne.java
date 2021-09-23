package stackAndQueueQuestions;

public class ThreeInOne {
	private int numberOfStack =3;
	private int stackCapaticy;
	private int[] values;
	private int[] sizes;
	
	public ThreeInOne(int size) {
		stackCapaticy = size;
		values =new int[size * numberOfStack];
		sizes = new int[numberOfStack];
	}
	
	//isFull
	public boolean isFull(int stackNum) {
		if(sizes[stackNum] == stackCapaticy) {
			return true;
		}else {
			return false;
		}
	}
	
	//isEmpty
	public boolean isEmpty(int stackNum) {
		if(sizes[stackNum] == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//indexOfTop
	public int indexOfTop(int stackNum) {
		int offset = stackNum *stackCapaticy;
		int size = sizes[stackNum];
		return offset + size -1;
	}
	
	//push
	public void push(int stackNum,int value) {
		if(isFull(stackNum)) {
			System.out.println("Stack is full");
		}else {
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}
	}
	
	//pop
	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			System.out.println("Stack is empty");
			return -1;
		}else {
			int indexValue = indexOfTop(stackNum);
			int value = values[indexValue];
			values[indexValue] = 0;
			sizes[stackNum]--;
			return value;
		}
	}
	
	//peek
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			System.out.println("Stack is Empty");
			return -1;
		}else {
			return values[indexOfTop(stackNum)];
		}
	}
	
	
	public static void main(String[] args) {
		
		ThreeInOne s = new ThreeInOne(3);
		
		System.out.println(s.isEmpty(0));
		System.out.println(s.isFull(0));
		
		s.push(0, 1);
		s.push(0, 8);
		s.push(2, 6);
		s.push(1, 9);
		s.push(2, 1);
		
		System.out.println(s.pop(0));
		System.out.println(s.pop(1));
		System.out.println(s.pop(2));
		
		System.out.println(s.peek(2));
		System.out.println(s.peek(2));
	}

}
