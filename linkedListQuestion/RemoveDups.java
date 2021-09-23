package linkedListQuestion;

import java.util.HashSet;

public class RemoveDups {

	public void removeDups(LinkedList ll) {
		HashSet<Integer> hs = new HashSet<>();
		Node curr = ll.head;
		Node prev = null;

		while (curr != null) {
			int currValue = curr.value;
			if (hs.contains(currValue)) {
				prev.next = curr.next;
				ll.size--;
			} else {
				hs.add(currValue);
				prev = curr;
			}
			curr = curr.next;
		}
	}

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.createLL(5);
		ll.insertLL(2);
		ll.insertLL(2);
		ll.insertLL(8);
		ll.insertLL(2);

		ll.traversalLL();
		
		RemoveDups rd = new RemoveDups();
		
		rd.removeDups(ll);
		
		ll.traversalLL();
	}

}
