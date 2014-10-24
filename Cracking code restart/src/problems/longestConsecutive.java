package problems;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive {

	
	public static int solve(int[] num){
		int ans= 0;
		
		HashSet<Integer> set = new HashSet<Integer>(num.length);
		
		for (int i:num){
			set.add(i);
		}
		
		int max = 0;
		
		for (int n:num){
			if (set.contains(n)){
				int length = 1;
				int next = n -1;
				while (set.contains(next)){
					
					length++;
					set.remove(next);
					next--;
				}
				
				next = n+1;
				
				while (set.contains(next)){
					
					length++;
					set.remove(next);
					next++;
					
				}
				
				if (max < length){
					max = length;
				}
				//System.out.println("length : "+length);
			}
			
			
		}
		
		
		
		
		
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {100,1,200,4,2,3,101,202,103,203,102};
		solve(num);
		
	}

}
