package dynamicProgramming;

import java.util.HashMap;

public class ConvertStringDP {

	// memoization
	
	static int CSMemo(String s1,String s2,int i1,int i2,HashMap<String, Integer> memo) {
		
		if(i1 == s1.length()) {
			return s2.length()-i2;
		}
		if(i2 == s2.length()) {
			return s1.length()-i1;
		}
		if(s1.charAt(i1) ==  s2.charAt(i2)) {
			return CSMemo(s1, s2, i1+1, i2+1, memo);
		}
		
		String memoKey = String.valueOf(i1) + String.valueOf(i2);
		if(!memo.containsKey(memoKey)) {
			int delete = 1+ CSMemo(s1, s2, i1, i2+1, memo);
			int insert = 1+ CSMemo(s1, s2, i1+1, i2, memo);
			int replace = 1+ CSMemo(s1, s2, i1+1, i2+1, memo);
		
			memo.put(memoKey, Math.min(delete, Math.min(insert, replace)));
		}
		
		return memo.get(memoKey);
	}
	
	
	
	public static void main(String[] args) {

		String s1 = "table";
		String s2 = "tbres";
		
		HashMap<String, Integer> hm = new HashMap<>();
		System.out.println(CSMemo(s1, s2, 0, 0, hm));

	}

}
