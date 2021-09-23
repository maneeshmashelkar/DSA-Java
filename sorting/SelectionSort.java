package sorting;

public class SelectionSort {

	public void selectionSort(int[] arr) {
		int n = arr.length;

		for (int j = 0; j < n; j++) {
			int minIndex = j;
			for (int i = j + 1; i < n; i++) {
				if (arr[minIndex] > arr[i]) {
					minIndex = i;
				}
			}
			if (minIndex != j) {
				int temp = arr[j];
				arr[j] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	public void print(int arr[]) {

		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println("");

	}
}
