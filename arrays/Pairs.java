package arrays;

import java.util.Arrays;

public class Pairs {

	public static void main(String[] args) {

		Pairs p = new Pairs();
		int[] arr = { 5, 7, 3, 8, 1 };

		int[] res = p.twoPairs(arr, 4);

		System.out.println(Arrays.toString(res));

	}

	public int[] twoPairs(int[] arr, int t) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == t) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("pair not found");
	}

}
