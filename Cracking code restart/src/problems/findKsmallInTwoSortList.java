package problems;

public class findKsmallInTwoSortList {

	
	public static int solve(int[] A,int[] B,int k){
		
		int m = A.length;
		int n = B.length;
		k--;
		if (k == 0) return (A[0]>B[0])?B[0]:A[0];
		if (k > m + n ) return -1;
		int la = Math.min(m-1, k);
		int lb = Math.min(n-1, k);
		
		int i = k*m/(m+n);
		
		int j = k-i-1;
		
		while (true){
			if (A[i]< B [j]){
				
				if (i == la || A[i+1] > B[j]){
					return B[j];
				}
				else {
					i += (la-i+1)/2;
					j = k-i-1;
				}
			}
			else {
				if (j == lb || B[i+1] > A[i]){
					return A[i];
				}
				
				else {
					j+=(lb-j+1)/2;
					i = k-j-1;
				}
			}		
		}
	}
	
	public static double findMedian(int[] A,int[] B){
		
		int m = A.length;
		int n = B.length;
		
		boolean isEven;
		
		if ((m+n)%2 == 0) isEven = true;
		else isEven = false;
		
		int k = (m+n) >> 1;
		if (isEven) return (solve(A,B,k)+solve(A,B,k+1)) /2.0;
		else return solve(A,B,k);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {0,2,4,6,8};
		int[] B = {1,3,5,7,9};
		int[] C = {10,11,12,13,14,15};	
		System.out.println(solve(C,B,8));
		
		System.out.println(findMedian(A,B));
		
	}

}
