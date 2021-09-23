package arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
//		SingleDimensionArray arr = new SingleDimensionArray(3);
//		arr.insert(0, 7);
//		arr.insert(1, 3);
//		arr.insert(2, 4);
//		arr.insert(1, 8);
//		arr.insert(5, 3);

//		System.out.println(arr.array[0]);
//		System.out.println(arr.array[1]);
//		System.out.println(arr.array[2]);
//		System.out.println(arr.array[3]);

//		System.out.println("\nArray traversal");
//		arr.traversal();

//		System.out.println("\nArray search");
//		arr.search(7);

//		System.out.println("\nArray delete");
//		arr.delete(1);

//		System.out.println("\nArray traversal");
//		arr.traversal();
		
		
		TwoDimensionArray a = new TwoDimensionArray(3, 3);
		a.insert(0, 1, 5);
		a.insert(1, 0, 4);
		a.insert(1, 2, 9);
		a.insert(1, 1, 6);
		
		System.out.println(Arrays.deepToString(a.array));

//		a.get(1, 1);
		
//		a.traversal();
		
//		a.search(9);
		
//		a.remove(1, 1);

		
	}

}
