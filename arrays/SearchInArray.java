package arrays;

public class SearchInArray {

	public static void main(String[] args) {
		SearchInArray s = new SearchInArray();
		
		int res =s.search(new int[] {2,3,47,7,84,9}, 84);
		System.out.println(res);
	}
	
	public int search(int[] arr,int t) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == t) {
				return i;
			}
		}
		return -1;
	}

}
