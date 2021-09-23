package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class FiboDP {
	
	// Memoization

	static int fiboMemo(int n, HashMap<Integer, Integer> memo) {

		if (n == 1) {
			return 0;
		}

		if (n == 2) {
			return 1;
		}

		if (!memo.containsKey(n)) {
			memo.put(n, fiboMemo(n - 1, memo) + fiboMemo(n - 2, memo));
		}

		return memo.get(n);
	}
	
	// Tabulation
	
	static long fiboTab(int n) {
		ArrayList<Long> tb = new ArrayList<>();
		tb.add(0l);
		tb.add(1l);
		for(int i=2;i<n;i++) {
			long n1 = tb.get(i-1);
			long n2 = tb.get(i-2);
			tb.add(n1+n2);
		}
		
		return tb.get(n-1);
	}
	

	public static void main(String[] args) {

//		HashMap<Integer, Integer> memo = new HashMap<>();
//		System.out.println(fiboMemo(3, memo));
		
		System.out.println(fiboTab(20));
	}

}
