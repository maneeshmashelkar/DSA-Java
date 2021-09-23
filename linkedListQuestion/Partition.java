package linkedListQuestion;

public class Partition {

	LinkedList partition(LinkedList ll, int x) {
		Node currenNode = ll.head;
		ll.tail = ll.head;
		while (currenNode != null) {
			Node next = currenNode.next;
			if (currenNode.value < x) {
				currenNode.next = ll.head;
				ll.head = currenNode;
			} else {
				ll.tail.next = currenNode;
				ll.tail = currenNode;
			}
			currenNode = next;
		}
		ll.tail.next = null;
		return ll;
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

		Partition p = new Partition();
		LinkedList lp = p.partition(ll, 4);
		lp.traversalLL();

	}

}
