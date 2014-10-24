package projectEuler;

public class Evenfibonacci {

	
	public static long solver(){
		
		
		int N = 1000;
		long ans = 0;
		long[] arr = new long[N];
		
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i< N ;i++){
			
			arr[i] = arr[i-2]+arr[i-1];
			
			if(arr[i] < 4000000 ){
				if (arr[i] % 2 == 0 )
					ans+= arr[i];
						
			}
			else break;
		
		}
		
		
		print1Arr(arr);					
		
		return ans;
	}
	
	public static void print1Arr(long[] arr){
		
		for (int i = 0;i< arr.length;i++){
			
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}
		
			
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Ans: "+solver());
		
		
		
	}

}
