package arrays;

public class TwoDimensionArray {

	int[][] array;

	public TwoDimensionArray(int row, int col) {

		array = new int[row][col];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = Integer.MIN_VALUE;
			}
		}
	}

	// insert value in array

	public void insert(int row, int col, int val) {

		try {
			if (array[row][col] == Integer.MIN_VALUE) {
				array[row][col] = val;
				System.out.println("value inserted");
			} else {
				System.out.println("value Already present in array");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("index not found in array");
		}
	}

	// get array value

	public void get(int row, int col) {
		try {
			System.out.println(array[row][col]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("array index not found");
		}
	}

	// traversal

	public void traversal() {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
	}

	// serach

	public void search(int val) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] == val) {
					System.out.println("row " + i + " col " + j);
					return;
				}
			}
		}

		System.out.println("item not found in array");
	}

	// delet item

	public void remove(int row, int col) {
		try {
			System.out.println("removed item "+ array[row][col]);
			array[row][col] = Integer.MIN_VALUE;
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("index not found in array");
		}
	}
}
