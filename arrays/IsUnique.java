package arrays;

public class IsUnique {

	public static void main(String[] args) {
		IsUnique u = new IsUnique();
		
		int[] arr = {3,6,4,9,2,7,8};
		
		System.out.println(u.isUnique(arr));
	}
	
	public boolean isUnique(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i] == arr[j]) {
					return false;
				}
			}
		}
		return true;
	}

}
