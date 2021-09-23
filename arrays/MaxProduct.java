package arrays;

public class MaxProduct {

	public static void main(String[] args) {

		MaxProduct m = new MaxProduct();
		
		int[] arr = {2,6,4,8,1,7,9};
		
		System.out.println(m.maxProduct(arr));
	}

	public String maxProduct(int[] arr) {
		int maxproduct = Integer.MIN_VALUE;
		String pair = "";

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i]*arr[j] > maxproduct) {
					maxproduct = arr[i]*arr[j];
					pair = Integer.toString(arr[i]) + ","+Integer.toString(arr[j]);
				}
			}
		}
		
		return pair;

	}
}
