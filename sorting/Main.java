package sorting;

public class Main {

	public static void main(String[] args) {

		int[] arr = { 9, 8, 7, 6, 1, 5, 4, 3, 2, 1 };

//		BubbleSort bs = new BubbleSort();
//		bs.bubbleSort(arr);
//		bs.print(arr);

//		SelectionSort ss = new SelectionSort();
//		ss.selectionSort(arr);
//		ss.print(arr);

//		InsertionSort is = new InsertionSort();
//		is.insertionSort(arr);
//		is.print(arr);

//		BucketSort bs = new BucketSort(arr);
//		bs.print();
//		bs.bucketSort();
//		System.out.println("");
//		bs.print();

//		MergeSort ms = new MergeSort();
//		ms.mergeSort(arr, 0, arr.length - 1);
//		ms.print(arr);
	
//		QuickSort qs = new QuickSort();
//		qs.quickSort(arr, 0, arr.length - 1);
//		qs.print(arr);
		
		HeapSort hs = new HeapSort(arr);
		hs.heapSort();
		hs.print(arr);;
	}
	

}
