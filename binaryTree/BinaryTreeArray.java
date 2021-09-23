package binaryTree;

public class BinaryTreeArray {

	public String[] arr;
	public int lastUsedIndex;
	
	public BinaryTreeArray(int size) {
		arr = new String[size+1];
		this.lastUsedIndex = 0;
		System.out.println("blank tree created of size "+ size);
	}
	
	// isFull
	public boolean isFull() {
		if(arr.length-1 == lastUsedIndex) {
			return true;
		}else {
			return false;
		}
	}
	
	// insert node
	public void insert(String value) {
		if(!isFull()) {
			arr[lastUsedIndex+1] = value;
			lastUsedIndex++;
			System.out.println(value+" inserted");
		}else {
			System.out.println("BT is full");
		}
	}
	
	//preOrder traversal
	public void preOrder(int index) {
		if(index >  lastUsedIndex) {
			return;
		}
		System.out.print(arr[index]+" ");
		preOrder( index * 2);
		preOrder(index * 2 + 1);

	}
	
	// inOrder traversal
	public void inOrder(int index) {
		if(index > lastUsedIndex) {
			return;
		}
		inOrder(index*2);
		System.out.print(arr[index]+" ");
		inOrder(index*2 + 1);

	}
	
	// postOrder traversal
	public void postorder(int index) {
		if(index > lastUsedIndex) {
			return;
		}
		postorder(index*2);
		postorder(index*2+1);
		System.out.print(arr[index]+" ");

	}
	
	// levelOrder traversal
	public void levelOrder() {
		for(int i=1;i<=lastUsedIndex;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// search
	public int search(String value) {
		for(int i=1;i<=lastUsedIndex;i++) {
			if(arr[i] == value) {
				System.out.println(value +" found in tree");
				return i;
			}
		}
		System.out.println("value not found in tree");
		return -1;
	}
	
	// delete node
	public void delete(String value) {
		int location = search(value);
		if(location == -1) {
			return;
		}else {
			arr[location]=arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println(value + " is deleted");
		}
	}
	
	// delete tree
	public void deleteTree() {
		try {
			arr= null;
			System.out.println("Tree is deleted!");
		}catch(Exception e) {
			System.out.println("not able to delete Tree");
		}
	}
	
	public static void main(String[] args) {
		
		BinaryTreeArray bTA = new BinaryTreeArray(10);
		
		bTA.insert("n1");
		bTA.insert("n2");
		bTA.insert("n3");
		bTA.insert("n4");
		bTA.insert("n5");
		bTA.insert("n6");
		bTA.insert("n7");
		bTA.insert("n8");
		bTA.insert("n9");
		
//		bTA.preOrder(1);
//		System.out.println("");
//		bTA.inOrder(1);
//		System.out.println("");
//		bTA.postorder(1);
//		System.out.println("");
//		bTA.levelOrder();
		
		
//		System.out.println(bTA.search("n6"));
		
//		bTA.delete("n2");
//		bTA.levelOrder();
		
		bTA.deleteTree();
	}

}
