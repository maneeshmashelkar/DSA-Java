package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class NumberFactorDP {

	// memoization

	static int NFMemo(int n, HashMap<Integer, Integer> memo) {
		if (n <= 2) return 1;
		if (n == 3) return 2;

		int sub1 = NFMemo(n - 1, memo);
		int sub2 = NFMemo(n - 3, memo);
		int sub3 = NFMemo(n - 4, memo);

		if (!memo.containsKey(n)) memo.put(n, sub1 + sub2 + sub3);

		return memo.get(n);
	}
	
	//tabulation
	
	static int NFTab(int n) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(1);
		arr.add(1);
		arr.add(2);
		
		for(int i=4;i<=n;i++) {
			int sub1 = n-1;
			int sub2 = n-3;
			int sub3 = n-4;
			
			arr.add(sub1+sub2+sub3);
		}
		
		return arr.get(n)-1;
		
	}

	public static void main(String[] args) {
		
//		HashMap<Integer, Integer> hm = new HashMap<>();
//		System.out.println(NFMemo(6, hm));
		
		System.out.println(NFTab(5));
	}

}
