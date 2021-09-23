package divideAndConquerQuestion;

public class ConvertOneStringToAnother {

	static int convertString(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length()) {
			return s2.length() - i2;
		}
		if (i2 == s2.length()) {
			return s1.length() - i1;
		}
		if (s1.charAt(i1) == s2.charAt(i2)) {
			return convertString(s1, s2, i1 + 1, i2 + 1);
		}
		int delete = 1 + convertString(s1, s2, i1, i2 + 1);
		int insert = 1 + convertString(s1, s2, i1 + 1, i2);
		int replace = 1 + convertString(s1, s2, i1 + 1, i2 + 1);
		int minNum = Math.min(delete, insert);
		return Math.min(replace, minNum);

	}

	public static void main(String[] args) {
		
		System.out.println(ConvertOneStringToAnother.convertString("table", "yabel", 0, 0));
	}

}
