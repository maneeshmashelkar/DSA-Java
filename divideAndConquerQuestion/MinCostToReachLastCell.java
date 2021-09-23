package divideAndConquerQuestion;

public class MinCostToReachLastCell {

	static int minCostToReachLastCell(int[][] mat, int row, int col) {
		if (row == -1 || col == -1) {
			return Integer.MAX_VALUE;
		}

		if (row == 0 && col == 0) {
			return mat[0][0];
		}
		int c1 = minCostToReachLastCell(mat, row, col - 1);
		int c2 = minCostToReachLastCell(mat, row - 1, col);
		int min = Integer.min(c1, c2);
		return min + mat[row][col];
	}

	public static void main(String[] args) {

		int[][] array = { { 4, 7, 8, 6, 4 }, { 6, 7, 3, 9, 2 }, { 3, 8, 1, 2, 4 }, { 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 } };

		
		System.out.println(MinCostToReachLastCell.minCostToReachLastCell(array, array.length-1, array[0].length -1));
	
	}
	
	

}
