package apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MixedFraction {

	public static long[] solve(long numer,long deno){
		
		
		long f = numer / deno;
		numer  = numer % deno;
		long[] ans = new long[3];
		
		ans[0] = f;
		ans[1] = numer;
		ans[2] = deno;
		
		
		return ans;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		long[] a =  solve(3,4000);
		
		
		System.out.println(a[0]+"  "+a[1]+" / "+a[2]);
		
		
	}

}
