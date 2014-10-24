package problems;

public class printNumberBiggerThanLeft {

	
	public static void solve(int n){
		
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		helper("",arr,0,n);
	}
	
	public static void helper(String pre,int[] arr,int start,int length){
		
		for (int i = start;i<arr.length;i++){
			int digit = arr[i];
			
			if (length == 1){
				System.out.println(pre+digit);
				
			}
			else helper(pre+digit,arr,digit,length-1);
				
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solve(3);	
		
		
	}

}
