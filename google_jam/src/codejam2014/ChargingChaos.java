package codejam2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class ChargingChaos {

	public static String charging(String[] original,String[] goal,int N,int L ){
		String ans = "";
		for (int i = 0;i<L;i++){
		String[] goal_m = modify(original,i);
			
		}
		
		return ans;
	}
	
	public static String[] modify(String[] original,int index){
		
		for (int i = 0;i<original.length;i++){
		char temp = original[i].charAt(index);
		StringBuilder sb = new StringBuilder(original[i]);
		if (temp == '1'){
			sb.setCharAt(index, '0');
			original[i]  = sb.toString() ;
		}
		else if (temp == '0'){
			sb.setCharAt(index, '1');
			original[i]  = sb.toString() ;		
			}
		}
		
		return original;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String inputfilename = "A-small-practice.in.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		
		ArrayList<Integer> worth = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		//System.out.println(cal(1,10));
		int lines = Integer.parseInt(br.readLine());	
		String line = "";
		for (int i = 0;i<lines;i++){
			String temp = "";		
			line = br.readLine();
			String[] s = line.split(" ");
			
			int number = i+1;
			int N = Integer.parseInt(s[0]);
			int L = Integer.parseInt(s[1]);
		  	
			String[] original  = br.readLine().split(" ");
			String[] goal = br.readLine().split(" ");
			
			
			 temp = "Case #"+number+": "+charging(original,goal,N,L);
			// temp = "Case #"+number+": "+calbig(s[0],s[1]);
			 
			 
			System.out.println(temp);
			bw.write(temp);
			bw.newLine();
		}	
		bw.close();
	}

}
