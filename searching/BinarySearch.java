package searching;

public class BinarySearch {

	public int binarySearch(int[] arr, int value) {
		
		int start = 0;
		int end = arr.length-1;
		int mid = (start+end)/2;
		
		while(arr[mid] != value && start <= end) {
			if(arr[mid] < value) {
				start = mid +1 ;
			}else {
				end = mid -1;
			}
			mid = (start+end)/2;
		}
		
		if(arr[mid] == value) {
			System.out.println("The element found at index "+ mid);
			return mid;
		}else {
			System.out.println(value+" not found in arr");
			return -1;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,7,9};
		
		BinarySearch bs = new BinarySearch();
		bs.binarySearch(arr, 1);
	}

}
