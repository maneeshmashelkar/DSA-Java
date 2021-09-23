package divideAndConquerQuestion;

public class ZeroOneKnapsack {

	static int zeroOneKnapsack(int[] profits,int[] weights,int capacity,int currentIndex) {
		if(capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length ) {
			return 0;
		}
		int profit1 = 0;
		if(weights[currentIndex] <= capacity) {
			profit1 = profits[currentIndex] + zeroOneKnapsack(profits, weights, capacity - weights[currentIndex], currentIndex+1);
		}
		int profit2 = zeroOneKnapsack(profits, weights, capacity, currentIndex+1);
		
		return Math.max(profit1, profit2);
		
	}
	
	
	public static void main(String[] args) {
		
		int[] profits = {31,26,17,72};
		int[] weights = {3,1,2,5};
		
		System.out.println(ZeroOneKnapsack.zeroOneKnapsack(profits, weights, 7, 0));
	}

}
