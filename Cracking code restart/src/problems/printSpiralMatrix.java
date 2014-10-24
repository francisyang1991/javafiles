package problems;

public class printSpiralMatrix {

	
	public static void solve(char[][] arr){
		
		int length = arr.length;
		StringBuffer sb = new StringBuffer();
		
		rec(arr,1,false,sb);
		
	}
	
	public static void rec(char[][] arr,int level,boolean isReverse,StringBuffer sb){
		
		
		if (level > arr.length){
			System.out.println(sb.toString());
		}
		else {
			if (isReverse){
				for (int i = arr[level-1].length-1;i>=0;i--){
					sb.append(arr[level-1][i]);
				}
				rec(arr,level+1,false,sb);

			}
			else {
				for (int i = 0;i<arr[level-1].length;i++){
					sb.append(arr[level-1][i]);
				}
				rec(arr,level+1,true,sb);
			}
				
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] a = {1};
		char[][] arr  = {{'a','b','c','d'},{'h','g','f','e'},{'i','j','k','l'}};
		System.out.println();
		solve(arr);
		String str = "";
		
	}

}