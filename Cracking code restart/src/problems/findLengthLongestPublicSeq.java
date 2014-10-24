package problems;

public class findLengthLongestPublicSeq {

	
	public static int solve(int[] arr){
		int ans = 0;
		int len = arr.length;
		
		int[] dp = new int[len];
		
		for (int i = 0;i<len;i++){
			dp[i] = 1;
		}
		
		for (int i = 1; i< len;i++){
			for (int j = 0;j<i;j++){
				if (arr[i] >arr[j] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		
		for (int n : dp){
		 if (ans < n){
			 ans = n;
		 }
		}
		
		return ans;
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60 };
		
		System.out.println("The length is :");
		System.out.println(solve(arr));
		
		
	}

}
