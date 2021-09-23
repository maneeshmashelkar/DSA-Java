package divideAndConquerQuestion;

public class FindLPS {
	
	static int findLPS(String s1,int start,int end) {
		if(start > end ) {
			return 0;
		}
		if(start == end ) {
			return 1;
		}
		int seq1 = 0;
		if(s1.charAt(start) == s1.charAt(end)) {

			seq1 =  2 + findLPS(s1, start+1, end-1);
		}
		
		int seq2 = findLPS(s1, start, end-1);
		int seq3 = findLPS( s1, start+1, end);
 
		return Math.max(seq1, Math.max(seq2, seq3));
	}

	public static void main(String[] args) {
		// longest palindromic subsequence 

		String s1 = "ELRMENMET";
		
		System.out.println(FindLPS.findLPS(s1, 0, s1.length()-1));
	}

}
