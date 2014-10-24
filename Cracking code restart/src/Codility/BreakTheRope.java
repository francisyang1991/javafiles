package Codility;

import java.util.ArrayList;
import java.util.Arrays;

public class BreakTheRope {
	
	public static int solve(int[] A, int[] B,int[] C){
		
		int len = A.length;

		int[] remain = Arrays.copyOf(A, len);
		boolean flag = true;   
		//int i = 0;

		if (len == 0){
			return 0;   
		}

		if (len == 1){
			if (A[0]>=B[0]){
				return 1;   
			}
			else {
				return 0;   
			}
		}

		int max = 0;

		for (int i = 0;i<len;i++) {
			// System.out.println("remain "+remain[i]);
			if (A[i] < B[i]) 
				return max;	
			if (C[i] == -1){
					remain[i] -=B[i];   
				}
			else {
				int j = C[i];  
				boolean checkDur = false;
				int hook = j;
				while (hook != -1){				
					if (remain[hook]>=B[i]){						
						hook = C[hook];
						checkDur = true;
						
						Arrays.sort(A);
						//int k = Math.sqrt(a);
						
						
					}
					else {
						checkDur = false;
						break;
					}
				}
				
				
				if (checkDur){
					if (A[i]  < remain[j]){

						remain[i] = A[i] - B[i]; 
					}
					else {
						remain[i] = remain[j] - B[i];   
					}

				//	updateDur(j,B[i],remain);
					int index = j; 
					int pat = index;
					while (index != -1){
						
						remain[index]-=B[i];
						pat = index;
						index = C[index];					
					}				
					
				}
				else break;   

			}                
			max++;        
		}

		return max;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {8, 7, 8, 10, 8, 7, 6, 6, 7, 10};
		int[] B = {2, 1, 5, 4, 1, 3, 3, 1, 1, 3};
		int[] C = {-1, 0, 0, -1, 3, 4, 3, 6, 2, -1};

		System.out.println("Max : "+solve(A,B,C));



	}

}
