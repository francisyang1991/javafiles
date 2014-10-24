package projectEuler;

public class Mulply3or5 {

	public static long solver(int N){
		
		long ans  = 0;
		
		int[] arr = new int[N];
		
		int n = 0;
		int i = 0;
		while( n < N){
			n++;
			if (n % 3 == 0){
				arr[i++] = n;
				ans+=n;
				continue;
			}
			else if (n % 5 == 0){
				arr[i++] = n;
				ans+=n;
				continue;
			}
			else continue;		
		}
		
		
		print1Arr(arr);
		
		System.out.println();
		return ans;
		
		
	}
	
	
	
	public static void print1Arr(int[] arr){
		
		for (int i = 0;i< arr.length;i++){
			
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solver(1000));
		
		
		
	}

}
