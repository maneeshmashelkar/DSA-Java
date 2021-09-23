package dynamicProgramming;

public class HouseRobberDP {

	// memoization
	 
	static int HRMemo(int[] houses,int currentHouse,int[] temp) {
		if(currentHouse > houses.length-1) return 0;
		
		if(temp[currentHouse] == 0 ) {
			int firstHouse = houses[currentHouse] + HRMemo(houses, currentHouse+2, temp);
			int skipFirstHouse = HRMemo(houses, currentHouse+1, temp);
			temp[currentHouse] = Math.max(firstHouse, skipFirstHouse);
		}
		
		return temp[currentHouse];
	}
	
	//tabulation
	
	static int HRTab(int[] houses,int currentHouse) {
		int[] temp = new int[houses.length+2];
		
		for(int i=houses.length-1;i>=0;i--) {
			temp[i] = Math.max(houses[i]+temp[i+2], temp[i+1]);
		}
		return temp[currentHouse];
	}
	
	
	
	public static void main(String[] args) {
		
		int[] houses = {6,7,1,30,8,2,4}; 
//		int[] temp = new int[houses.length]; 
//		System.out.println(HRMemo(houses, 0, temp));
		
		
		System.out.println(HRTab(houses, 0));
	}

}
