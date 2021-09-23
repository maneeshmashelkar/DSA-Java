package linkedListQuestion;

public class SumList {

	LinkedList sumList(LinkedList lla,LinkedList llb) {
		Node n1= lla.head;
		Node n2 = llb.head;
		int carry =0;
		LinkedList resultLL = new LinkedList();
		while(n1 != null || n2 != null) {
			int result = carry;
			if(n1 != null) {
				result += n1.value;
				n1 = n1.next;
			}
			if(n2 != null) {
				result += n2.value;
				n2 = n2.next;
			}
			resultLL.insertLL(result%10);
			carry = result /10;
		}
		return resultLL;
	}
	
	public static void main(String[] args) {
		LinkedList lla = new LinkedList();

		lla.createLL(7);
		lla.insertLL(1);
		lla.insertLL(6);
		
		LinkedList llb = new LinkedList();

		llb.createLL(5);
		llb.insertLL(9);
		llb.insertLL(2);
		
		SumList s = new SumList();
		LinkedList r = s.sumList(lla, llb);
		r.traversalLL();

	}

}
