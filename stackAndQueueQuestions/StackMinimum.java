package stackAndQueueQuestions;

public class StackMinimum {
	Node top;
	Node min;
	
	public StackMinimum() {
		top =null;
		min=null;
	}
	
	public int min() {
		return min.value;
	}
	
	public void push(int nodeValue) {
		if(min ==null) {
			min = new Node(nodeValue,min);
		}else if(min.value > nodeValue) {
			min = new Node(nodeValue,min);
		}else {
			min = new Node(min.value,min);
		}
		top = new Node(nodeValue,top);
	}
	
	public int pop() {
		min = min.next;
		int result =top.value;
		top = top.next;
		return result;
	}
	
	
	public static void main(String[] args) {
		
		StackMinimum s = new StackMinimum();
		
		s.push(3);
		s.push(5);
		s.push(2);
		s.push(1);
		
		s.pop();
		s.pop();
		
		System.out.println(s.min());
	}

}
