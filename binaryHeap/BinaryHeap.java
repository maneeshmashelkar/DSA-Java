package binaryHeap;

public class BinaryHeap {

	int arr[];
	int sizeOfHeap;

	public BinaryHeap(int size) {
		arr = new int[size + 1];
		this.sizeOfHeap = 0;
		System.out.println("Binary Heap is Created of size " + size);
	}

	// isEmpty
	public boolean isEmpty() {
		if (sizeOfHeap == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// peek
	public Integer peek() {
		if (isEmpty()) {
			System.out.println("BH is empty!");
			return null;
		}
		return arr[1];
	}

	//size of heap
	public int sizeOfBH() {
		return sizeOfHeap;
	}

	// levelOrder traversal
	public void levelOrder() {
		for (int i = 1; i <= sizeOfHeap; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	// heapifyBottomToTop method
	
	private void heapifyBottomToTop(int index,String heapType) {
		int parent = index / 2;
		
		if(index <= 1) {
			return;
		}
		
		if(heapType == "Min") {
			if(arr[index] < arr[parent]) {
				int temp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		}else if(heapType == "Max") {
			if(arr[index] > arr[parent]) {
				int temp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		}
		
		heapifyBottomToTop(parent, heapType);
	}
	
	
	// insert node
	public void insert(int value,String heapType) {
		arr[sizeOfHeap+1] = value;
		sizeOfHeap++;
		heapifyBottomToTop(sizeOfHeap, heapType);
	}
	
	// heapifyTopToBottom 
	private void heapifyTopToBottom(int index,String heapType) {
		int left = index * 2;
		int right = index * 2 + 1;
		int swapChild = 0;
		
		if(sizeOfHeap < left ) {
			return;
		}
		
		if(heapType == "Max") {
			if(sizeOfHeap  ==  left) {
				if(arr[index] < arr[left]) {
					int temp = arr[index];
					arr[index]  =  arr[left];
					arr[left] = temp;
				}
				return;
			}else {
				if(arr[left] > arr[right]) {
					swapChild = left;
				}else {
					swapChild = right;
				}
				
				if(arr[index] < arr[swapChild]) {
					int temp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = temp;
				}
			}
		}else if(heapType == "Min") {
			if(sizeOfHeap  ==  left) {
				if(arr[index] > arr[left]) {
					int temp = arr[index];
					arr[index]  =  arr[left];
					arr[left] = temp;
				}
				return;
			}else {
				if(arr[left] < arr[right]) {
					swapChild = left;
				}else {
					swapChild = right;
				}
				
				if(arr[index] > arr[swapChild]) {
					int temp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = temp;
				}
			}
		}
		
		heapifyTopToBottom(swapChild, heapType);
		
	}
	
	//extract
	public int extract(String heapType) {
		if(isEmpty()) {
			System.out.println("BH is empty!");
			return -1;
		}else {
			int temp = arr[1];
			arr[1] = arr[sizeOfHeap];
			sizeOfHeap--;
			heapifyTopToBottom(1, heapType);
			return temp;
		}
	}
	
	//delete BH
	public void deleteBH() {
		arr=null;
		System.out.println("BH is deleted successfully!");
	}
	
	public static void main(String[] args) {

		BinaryHeap bh = new BinaryHeap(5);
		
		bh.insert(8, "Min");
		bh.insert(3, "Min");
		bh.insert(6, "Min");
		bh.insert(1, "Min");
		bh.insert(4, "Min");
		
		bh.levelOrder();
		
		System.out.println(bh.extract("Min"));
		
		bh.levelOrder();
		
//		bh.deleteBH();
		
		System.out.println(bh.peek());
	}

}
