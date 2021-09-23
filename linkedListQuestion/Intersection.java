package linkedListQuestion;

public class Intersection {

	Node getkthNode(Node head,int k) {
		Node current = head;
		while(k>0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}
	
	Node findInterSection(LinkedList list1,LinkedList list2) {
		if(list1.head ==null || list2.head == null) return null;
		if(list1.tail != list2.tail) {
			return null;
		}
		Node shorter = new Node();
		Node longer = new Node();
		if(list1.size >list2.size) {
			longer = list1.head;
			shorter = list2.head;
		}else {
			longer = list2.head;
			shorter = list2.head;
		}
		
		longer = getkthNode(longer, Math.abs(list1.size-list2.size));
		while(shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}
	
	void addSameNode(LinkedList lla,LinkedList llb,int nodeValue) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		lla.tail.next = newNode;
		lla.tail = newNode;
		llb.tail.next=newNode;
		llb.tail = newNode;
	}
	
	public static void main(String[] args) {
		LinkedList lla = new LinkedList();

		lla.createLL(3);
		lla.insertLL(1);
		lla.insertLL(5);
		lla.insertLL(9);
		
		LinkedList llb = new LinkedList();

		llb.createLL(2);
		llb.insertLL(4);
		llb.insertLL(6);
		
		Intersection i = new Intersection();
		i.addSameNode(lla, llb, 7);
		i.addSameNode(lla, llb, 2);
		i.addSameNode(lla, llb, 2);

		Node inter = i.findInterSection(lla, llb);
		System.out.println(inter.value);
	}

}
