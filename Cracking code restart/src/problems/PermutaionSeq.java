package problems;

import java.util.ArrayList;

public class PermutaionSeq {

	public static String findKPer(int n, int k){
		
		if (n == 1) return "1";
		
		StringBuffer ans = new StringBuffer();
		
		long[] fact = new long[n+1];
		fact[0] = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1 ;i<=n;i++){
			fact[i] = fact[i-1]*i;
			list.add(i);
		}
		long kk = k;
		long temp = 0;
		long remain = 0;
		for (int i = n-1;i>=1;i--){
			
			temp = kk / fact[i];
			remain = kk % fact[i];
			ans.append(list.get((int) temp));
			list.remove((int)temp);
			kk = remain;
		}
		ans.append(list.remove(0));
		return ans.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKPer(4,24));
	}

}
