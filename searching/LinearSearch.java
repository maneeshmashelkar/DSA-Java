package searching;

public class LinearSearch {

	public int linearSearch(int[] arr,int value) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == value) {
				System.out.println("The element found at index "+ i);
				return i;
			}
		}
		System.out.println(value+" not found in arr");
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr= {8,2,9,34,6,86,327,81,36,27};
		
		LinearSearch ls = new LinearSearch();
		ls.linearSearch(arr, 810);

	}

}
