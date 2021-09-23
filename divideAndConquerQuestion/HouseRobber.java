package divideAndConquerQuestion;

public class HouseRobber {

	static int houseRobber(int[] houses,int currentHouse) {
		if(currentHouse >= houses.length) {
			return 0;
		}
		
		int takeFirstHouse = houses[currentHouse] + houseRobber(houses, currentHouse+2);
		int skipFirstHouse = houseRobber(houses, currentHouse+1);
		
		return Math.max(takeFirstHouse, skipFirstHouse);
		
	}
	
	
	public static void main(String[] args) {
		
		int[] houses = {6,7,1,30,8,2,4};
		
		System.out.println(HouseRobber.houseRobber(houses, 0));
	
	}

}
