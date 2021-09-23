package recursion;

public class Questions {
	public static void main(String arg[]) {
		Questions q = new Questions();
//		System.out.println(q.sumOfDigit(145));
//		System.out.println(q.power(2,5));
//		System.out.println(q.GCD(8,4));
//		System.out.println(q.dectobin(25));
//		q.decBin(13);
		int arr[] = {3,6,8,9,23};
		System.out.println(q.maxofarr(arr,5));
	}
	
	public int sumOfDigit(int n) {
		if(n<0) {
			return 0;
		}
		if(n==0) {
			return 0;
		}
		
		return n%10 + sumOfDigit(n/10);
	}
	
	public int power(int x,int n) {
		if(n<0) {
			return -1;
		}
		if(n==0 || n==1) {
			return 1;
		}
		
		return x  * power(x,n-1);
	}
	
	public int GCD(int a,int b) {
		if(a<0 || b<0) {
			return -1;
		}
		if(b==0) {
			return a;
		}
		
		return GCD(b,a%b);
	}
	
	public int dectobin(int n) {
		if(n==0) {
			return 0;
		}
		
		return n%2 + 10 * dectobin(n/2);  
	}
	
	public void decBin(int n) {
		if(n==0) {
			return;
		}
		
		decBin(n/2);
		System.out.print(n%2);
	}
	
	public int maxofarr(int[] arr,int n) {
		if(n==1) {
			return arr[0];
		}
		return Math.max(arr[n-1], maxofarr(arr, n-1));
	}
	
	
}
