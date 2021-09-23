package divideAndConquerQuestion;

public class NumberOfPathsToReachTheLastCell {

	static int numberOfPaths(int array[][],int row,int col,int cost) {
		if(cost < 0) {
			return 0;
		}
		if(row == 0 && col ==0) {
			return (array[0][0]-cost ==0)? 1: 0; 
		}
		
		if(row == 0) {
			return numberOfPaths(array, 0, col-1, cost -array[row][col]);
		}
		
		if(col == 0) {
			return numberOfPaths(array, row-1, 0, cost - array[row][col]);
		}
		
		int noOFPathsFromPreviousRow = numberOfPaths(array, row-1, col, cost-array[row][col]);
		int noOfPathsFromPreviousCol = numberOfPaths(array, row, col-1, cost - array[row][col]);
		
		return noOFPathsFromPreviousRow + noOfPathsFromPreviousCol;
	}
	
	
	public static void main(String[] args) {
		
		int[][] array = { { 4, 7, 1, 6 }, { 5, 7, 3, 9 }, { 3, 2, 1, 2 }, { 7, 1, 6, 3 } };
		int cost = 25;

		System.out.println(
				NumberOfPathsToReachTheLastCell.numberOfPaths(array, array.length - 1, array[0].length - 1, cost));

		

	}

}
