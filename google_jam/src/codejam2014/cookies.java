package codejam2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class cookies {

	
	public static double cookie(double c, double f,double x){
		
		double currentC = 0;
		double speed = 2;
		double ans = 0;
		while (true){
			
			double time1 = x/speed;		
			double time2 = (c/speed)+x/(speed +f);
			if (time1 < time2){
				ans += time1;
				
				return ans;
			}
			else {
				ans = ans + c/speed;
				speed = speed +f;
				
			}	
		}	
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String inputfilename = "A-small-practice.in.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		
		int lines = Integer.parseInt(br.readLine());	
		String line = "";
		String temp = "";
		
		for (int i = 0;i<lines;i++){
			line = br.readLine();
			String[] s = line.split(" ");
			double c = Double.parseDouble(s[0]);
			double f = Double.parseDouble(s[1]);
			double x = Double.parseDouble(s[2]);
			temp = "Case #"+(i+1)+": ";
			temp += cookie(c,f,x);
			System.out.println(temp);
			bw.write(temp);
			bw.newLine();
		}
		
		bw.close();	
		
	}

}
