package problems;

public class rotateMattrix {

	public static void print(int[][] arr,int n){
		for (int i = 0;i<n;i++){
			for (int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = 5;
		int[][] mat = new int[n][n];
		
		
		int m = 1;
		for (int i = 0;i<n;i++){
			for (int j=0;j<n;j++){
				mat[i][j] = m;
				m++;
			}
		}
		
		print(mat,n);
		
		
		
		for (int i = 0;i<n/2;i++){
			for (int j = i;j<n-1-i;j++){
				int temp = mat[i][j];
				mat[i][j] =  mat[n-j-1][i];
				mat[n-j-1][i] = mat[n-i-1][n-j-1];
				mat[n-i-1][n-j-1] = mat[j][n-i-1];
				mat[j][n-i-1] = temp;			
			}
		}
		
		print(mat,n);
		
		
		
	}

}
