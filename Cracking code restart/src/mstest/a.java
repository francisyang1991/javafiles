package mstest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class a {

	
		public static long solve(int m, int n){
			
			
			return 0;
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
					
				temp = "Case #"+number+": "+solve(m,n);
				System.out.println(temp);
		    
				bw.write(temp);
				bw.newLine();
			}	
			bw.close();
			
			
//			String ss = "lines";
//			System.out.println(ss.substring(4, 6));
		}
		
		
	}

