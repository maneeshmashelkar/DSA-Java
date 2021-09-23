package greedyQuestion;

import java.util.Arrays;

public class CoinChangeProblem {

	static void coinChangeProblem(int[] coins,int n) {
		Arrays.sort(coins);
		int index = coins.length-1;
		while(true) {
			int coinValue = coins[index];
			index--;
			int maxAmount = (n/coinValue)*coinValue;
			if(maxAmount > 0) {
				System.out.println("Coin value: " +coinValue+" taken count: "+(n/coinValue));
				n=n - maxAmount;
			}
			if(n == 0) break;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] coins= {1,2,5,10,20,50,10,1000};
		int amount = 2035;
		System.out.println("coins available: "+ Arrays.toString(coins));
		System.out.println("target amount: "+ amount);
		CoinChangeProblem.coinChangeProblem(coins, amount);

	}

}
