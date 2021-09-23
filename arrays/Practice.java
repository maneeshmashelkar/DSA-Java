package arrays;

import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		
		// 1D array
		
//		int[] num;
//		num = new int[3];
//		num[0] = 3;
//		num[1] = 2;
//		num[2] = 1;
//		Arrays.fill(num, 33);
//		System.out.println(Arrays.toString(num));
		
		
//		String[] arr = {"a","d","b"};
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		
		// 2d Array
		
		int[][] i2darr;
		i2darr = new int[2][2];
		i2darr[0][0] = 1;
		i2darr[0][1] = 2;
		i2darr[1][0] = 3;
		i2darr[1][1] = 4;
		
		System.out.println(Arrays.deepToString(i2darr));
		
	}

}
