package apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class password {

	
		public static long password(int m, int n){
			
			 long mod = 1000000007;
			 int N =200;
			 long[][] c = new long[N][N];
			 
//			 for (int i = 1; i < N;i++){
//				 c[i][0] = c[i][i] = 1;
//				 
//				 for (int j = 1; j < i ;j++){
//					 c[i][j] = (int) ((c[i-1][j-1] + c[i-1][j]) % mod);
//					 
//				 }
//			 }
			 
			 
			 
			 c[0][0] = 1;
			for (int i = 1; i <= 105; i ++) {
					c[i][0] = 1;
			for (int j = 1; j <= 105; j ++) 
				c[i][j] = (int) ((c[i - 1][j] + c[i - 1][j - 1]) % mod);
			}
			//print2Array(c,105,105);
			 
			 long[][] f = new long [N][N];
			 
			 
			 for (int i = 1; i <= 105; i ++) 
				 
				 f[1][i] = 1;
				
			 for (int i = 2; i <= 105; i ++)
					for (int j = i; j <= 105; j ++) {
						for (int k = 1; k <= j - i + 1; k ++)
							f[i][j] = (f[i][j] + f[i - 1][j - k] * c[j][k]) % mod;
					}
			 
			// print2Array(f,105,105);
			 
			 
			 
			 
			 return f[m][n];
			 
	
			
			
		}
	
		static void print2Array(long[][] arr,int l,int h){
			
			int m = l;
			int n = h;
			
			for (int i = 0;i< m;i++){
				
				for (int j = 0;j<n;j++){
					
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			
			
		}

		public static long factorial(int n) {
	        long fact = 1; // this  will be the result
	        for (int i = 1; i <= n; i++) {
	            fact *= i;
	        }
	        return fact;
	    }
		
	
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			String inputfilename = "A-small-attempt0.in-2.txt";
			String output = "output.txt";
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
			
			
			//readPhoneNumber(0000000000,);
			
			
			//System.out.println(password(15, 15));
			
			int number = 0;
			int lines = Integer.parseInt(br.readLine());	
			String line = "";
			for (int i = 0;i<lines;i++){
				String temp = "";
				line = br.readLine();
				String[] s = line.split(" ");
				
				number = i + 1;
				int m = Integer.parseInt(s[0]);	
				int n = Integer.parseInt(s[1]);	
					
				temp = "Case #"+number+": "+password(m,n);
				System.out.println(temp);
		    
				bw.write(temp);
				bw.newLine();
			}	
			bw.close();
			
			
//			String ss = "lines";
//			System.out.println(ss.substring(4, 6));
		}
		
		
	}

