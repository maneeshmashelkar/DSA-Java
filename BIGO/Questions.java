package BIGO;

import java.util.Arrays;

public class Questions {

	public static void main(String[] args) {
		Questions q = new Questions();
		int arr[] = { 1, 2, 3, 4, 5 };
//		int arr2[] = { 5, 4, 3, 2 };

//		q.sumProduct(arr);
//		q.pairOfArr(arr);
//		q.unorderpairOfArr(arr);
//		q.pairOfTwoArr(arr, arr2);
//		q.pairOfTwoArr3loop(arr, arr2);
//		q.reverseArray(arr);
		q.reversearr(arr);
	}

	public void sumProduct(int[] arr) { // O(n)
		int sum = 0;
		int product = 1;
		for (int a : arr) {
			sum += a;
			product *= a;
		}

		System.out.println("sum is " + sum + " product is " + product);
	}

	public void pairOfArr(int[] arr) { // O(n^2)
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i] + "" + arr[j] + ", ");
			}
			System.out.println("");
		}
	}

	public void unorderpairOfArr(int[] arr) { // O(n^2)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				System.out.print(arr[i] + "" + arr[j] + ", ");
			}
			System.out.println("");
		}
	}

	public void pairOfTwoArr(int[] arr1, int[] arr2) { // O(mn)
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr2.length; j++) {
				System.out.print(arr1[i] + "" + arr2[j] + ", ");
			}
			System.out.println("");
		}
	}

	public void pairOfTwoArr3loop(int[] arr1, int[] arr2) { // O(mn)
		for (int i = 0; i < arr1.length; i++) {
			for (int j = i + 1; j < arr2.length; j++) {
				for (int k = 0; k < 1000000; k++) {				//O(1)
					System.out.println(arr1[i] + "" + arr2[j] + ", ");
				}
			}		
		}
	}
	
	public void reverseArray(int[] arr) { 		//O(n)
		int[] a = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			a[i] = arr[arr.length-i-1];
		}
		
		for(int ar:a) {
			System.out.print(ar+" ");
		}
	}
	
	public void reversearr(int[] arr) {			//O(n)
		
		for(int i=0;i<arr.length/2;i++) {
			int other = arr.length-i-1;
			int temp = arr[i];
			arr[i] = arr[other];
			arr[other]= temp;
		}
		
		System.out.println(Arrays.toString(arr));
	}

}
