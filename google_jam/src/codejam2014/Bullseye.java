package codejam2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Bullseye {

	public static long cal(long start,long t){
		long num = 0;
		long temp = 0;
			temp = t - sq(start+1,start);
			System.out.println("temp = "+temp);
			while (temp >= 0){
				num++;
				start +=2;
				temp  = temp - sq(start+1,start);
			}
			
		return num;
	}
	
	
	
	public static long sq(long a,long b){
		
		//System.out.println(a*a);
		return (a*a-b*b);
		
	}
	public static String calbig(String start,String t){
		BigInteger num = new BigInteger("0");
		BigInteger temp = new BigInteger("0");
		BigInteger tt = new BigInteger(t);
		BigInteger ss = new BigInteger(start);
		
			temp = tt.subtract(sqbig(ss.add(new BigInteger("1")),ss));
			System.out.println("temp = "+temp);
			while (temp.compareTo(BigInteger.ZERO)>=0){
				num.add(BigInteger.ONE);
				ss.add(new BigInteger("2"));
				temp  = temp.subtract(sqbig(ss.add(new BigInteger("1")),ss));
			}
			
		return num.toString();
	}
	
	
	
	public static BigInteger sqbig(BigInteger a,BigInteger b){
		
		//System.out.println(a*a);
		return (a.pow(2).subtract(b.pow(2)));
		
	}
	public static void main(String[] args) throws IOException {
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
			//StringBuffer sb = new StringBuffer();
			//String str = br.readLine();
			//System.out.println(str);
			//int num = Integer.parseInt(str);
			line = br.readLine();
			String[] s = line.split(" ");
			
			int number = i+1;
			
			
			
		  	long start = Integer.parseInt(s[0]);
			long t = Integer.parseInt(s[1]);	
			
			BigInteger bs = new BigInteger(s[0]);
			BigInteger tt = new BigInteger(s[1]);
			
			
			 temp = "Case #"+number+": "+cal(start,t);
			// temp = "Case #"+number+": "+calbig(s[0],s[1]);
			 
			 
			 System.out.println(temp);
			bw.write(temp);
			bw.newLine();
		}	
		bw.close();
	
	}

}
