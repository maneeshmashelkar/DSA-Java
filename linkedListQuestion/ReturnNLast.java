package linkedListQuestion;

public class ReturnNLast {

	public Node returnNLast(LinkedList ll,int n) {
		Node p1 = ll.head;
		Node p2 = ll.head;
		
		for(int i=0;i<n;i++) {
			if(p2 == null) return null;
			p2 = p2.next;
		}
		
		
		while(p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

		ll.createLL(5);
		ll.insertLL(2);
		ll.insertLL(1);
		ll.insertLL(8);
		ll.insertLL(9);
		ll.insertLL(3);

		ll.traversalLL();
		
		ReturnNLast r = new ReturnNLast();
		
		System.out.println(r.returnNLast(ll, 2).value);

	}

}
