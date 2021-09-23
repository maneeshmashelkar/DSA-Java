package sorting;

import binaryHeap.BinaryHeap;

public class HeapSort {

	int[] arr=null;

	public HeapSort(int[] arr) {
		this.arr = arr;
	}

	public void heapSort() {

		BinaryHeap bh = new BinaryHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			bh.insert(arr[i], "Min");
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = bh.extract("Min");
		}
	}

	public void print(int arr[]) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("");
	}
}
