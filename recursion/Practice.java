package recursion;

public class Practice {
	public static void main(String arg[]) {
//		recursion.naturalno(4);
//		System.out.println(recursion.poweroftwo(4));
//		System.out.println(iterative.poweroftwo(4));
//		System.out.println(recursion.factorial(-1));
		System.out.println(recursion.fibonacci(4));
		
	}
}

class recursion{
	static void naturalno(int n){
		if(n==0) {
			System.out.println(n+" is less than zero");
		}else {
			naturalno(n-1);
			System.out.println(n);
		}
	}
	
	static int poweroftwo(int n) {
		if(n == 0) {
			return 1;
		}else {
			int power = 2 * poweroftwo(n-1);
			return power;
		}
	}
	
	static int factorial(int n) {
		if(n<0) {
			return -1;
		}
		if(n==0 || n==1) {
			return  1;
		}
		return factorial(n-1) * n;
	}
	
	static int fibonacci(int n) {
		if(n<0) {
			return -1;
		}
		if(n==0 || n==1 ) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
}

class iterative{
	static int poweroftwo(int n) {
		int power = 1;
		int i=0;
		while(i < n) {
			power *= 2;
			i++;
		}
		return power;
	}
}
