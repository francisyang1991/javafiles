package china_qu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class capitainhammer {

	public static double captain(int v, int d){
		double ans = 0;
		double dd  = d;
		double vv  = v;
		double k = 0;
		double pi = Math.acos(-1);
		
		DecimalFormat df3  = new DecimalFormat("##.0000000");
		k = dd*9.8/(vv*vv);
		if (k>1) k = 1;
		double theta = Math.toDegrees(Math.asin(k)/2);
		if (ans< 0)
			System.out.println(ans);
	
		  
		return theta;
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputfilename = "B-small-practice.in.txt";
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
			
			int v = Integer.parseInt(s[0]);
			int d = Integer.parseInt(s[1]);
			int number = i+1;
			temp = "Case #"+number+": "+captain(v,d);
			//System.out.println(reverseWords(line));
			bw.write(temp);
			bw.newLine();
		}	
		bw.close();
	}

}
