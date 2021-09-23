package arrays;

public class SingleDimensionArray {

	int[] array = null;

	public SingleDimensionArray(int size) {
		array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = Integer.MIN_VALUE;
		}
	}

	public void insert(int loc, int val) {
		try {
			if (array[loc] == Integer.MIN_VALUE) {
				array[loc] = val;
				System.out.println("value inserted");
			} else {
				System.out.println("given location is occupied");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("invalid index to access array");
		}
	}

	// Array Traversal

	public void traversal() {
		try {
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		} catch (Exception e) {
			System.out.println("Array does not exists!!");
		}
	}

	// Searching in the array

	public void search(int val) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == val) {
				System.out.println("item found at the index of " + i);
				return;
			}
		}
		System.out.println(val + " not found in array");
	}

	// delete value

	public void delete(int index) {
		try {
			array[index] = Integer.MIN_VALUE;
			System.out.println("item deleted!");
		} catch (Exception e) {
			System.out.println("index does not exist in array");
		}
	}

}