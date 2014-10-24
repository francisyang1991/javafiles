package china_roundA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class rationalnumtree {

	public static long pq2number(long p,long q){
		System.out.println("p = "+ p + "  q = " +q);
		if (p ==1 && q == 1){
			return 1;		
		}
		else if (p > q) return pq2number(p-q,q)*2+1;
		else return pq2number(p,q-p)*2;
		
	}
	
	public static long[] number2pq(long n){
		long[] number = new long[2];
		long num = n;
		//int ii = Math.l
		ArrayList<Long> trace = new ArrayList<Long>();
		trace.add(n);
		while (n>1){
			n = n>>1;
			trace.add(n);
			System.out.println("n = "+ n);
		}
		long p  = 1;
		long q =  1;
		for (int i = trace.size()-2;i>=0;i--){
			num = trace.get(i);
			if (num % 2 == 0){
				q = p+q;				
			}
			else p = p+q;			
			System.out.println("p = "+ p + "  q = " +q);
		}	
		number[0]  = p;
		number[1]  = q;
		return number;
		
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputfilename = "B-large-practice.in.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		
		ArrayList<String> words = new ArrayList<String>();
		int lines = Integer.parseInt(br.readLine());	
		String line = "";
		for (int i = 0;i<lines;i++){
			String temp = "";
			line = br.readLine();
			String[] s = line.split(" ");
			int number = i+1;
			 if (s[0].equals("1")){
				long[] ans = number2pq(Long.parseLong(s[1]));
				 temp = "Case #"+number+": "+ ans[0]+" "+ans[1];
			 }
			 else {
				 long p = Long.parseLong((s[1]));
				 long q = Long.parseLong((s[2]));
				 temp = "Case #"+number+": "+pq2number(p,q);
			 }
			//System.out.println(temp);
	    
			bw.write(temp);
			bw.newLine();
		}	
		bw.close();
	}

}
