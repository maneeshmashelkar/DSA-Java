package arrays;

import java.util.Arrays;

public class RotateMatrix {

	public static void main(String[] args) {
		RotateMatrix r= new RotateMatrix();
		
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(r.rotateMatrix(arr));
		System.out.println(Arrays.deepToString(arr));
	}

//	public boolean rotateMatrix(int[][] arr) {
//		if(arr.length ==0 || arr.length != arr[0].length) {
//			return false;
//		}
//		int n=arr.length;
//		for(int layer=0;layer<n/2;layer++) {
//			int first = layer;
//			int last = n-1-layer;
//			for(int i=first;i<last;i++) {
//				int offset = i-first;
//				int top = arr[first][i];
//				arr[first][i] =arr[last-offset][first];
//				arr[last-offset][first] = arr[last][last-offset];
//				arr[last][last-offset] = arr[i][last];
//				arr[i][last] = top;
//			}
//		}
//		return true;
//	}
	
	public boolean rotateMatrix(int[][] mat) {
		if(mat.length == 0 || mat.length != mat[0].length) {
			return false;
		}
		int n=mat.length;
		for(int layer = 0; layer<n/2;layer++) {
			int first = layer; 			// 0
			int last = n - 1-layer;		// 3-1-0 = 2
			for(int i = first;i<last;i++) {
				int offset = i-first;		// 0-0 = 0
				int top = mat[first][i];	// 									[0][0]
				mat[first][i] = mat[last-offset][first];	//2-0 0 			[2][0]
				mat[last-offset][first] = mat[last][last-offset];	// 2 2-0	[2][2]
				mat[last][last-offset] = mat[i][last];			//0 2  			[0][2]
				mat[i][last] = top;
			}
		}
		return true;
	}
	
}
