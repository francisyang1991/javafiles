package codejam2014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class war {

	
	public static ArrayList<Integer> war(ArrayList<Double> a,ArrayList<Double> b){ 
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		Collections.sort(a);
		Collections.sort(b);
		
		ArrayList<Double> sorta = new ArrayList<Double>(a);
		ArrayList<Double> sortb = new ArrayList<Double>(b);
		
		
		for (int k = 0;k<a.size();k++){
			//System.out.println(a.get(k)+" "+ b.get(k));
		}
		
	
		int ans1 = 0;
		int ans2 = 0;
		for (int k = 0;k<a.size();k++){
			if (a.get(k)>b.get(k)){
				ans1++;
			}
			else {
				double temp = b.get(a.size()-1);
				b.remove(a.size()-1);
				b.add(0,temp);
				
			}
		}
		int j = 0;
		int k = 0;
		
		while (j<sorta.size()){
			double nomi = sorta.get(k);		
			
			if (nomi < sortb.get(j)){
				//System.out.println(sortb.get(j));
				ans2++;
				j++;
				k++;
				
			}
			else if (nomi == sortb.get(j)){
				j++;
				k++;
			}
			else {
				j++;
			}
		}
			
			
			
		
		
		ans.add(ans1);
		ans.add(a.size()-ans2);
		
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
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
			
			int len = Integer.parseInt(line);
			ArrayList<Double> a = new ArrayList<Double>();
			ArrayList<Double> b = new ArrayList<Double>();
			line = br.readLine();
			String[] s = line.split(" ");
			
			for (int k = 0;k<len;k++){
				a.add(Double.parseDouble(s[k]));
			}
			line = br.readLine();
			 s = line.split(" ");
			
			for (int k = 0;k<len;k++){
				b.add(Double.parseDouble(s[k]));
			}
			
			temp = "Case #"+(i+1)+": ";
			ArrayList<Integer> ans = war(a,b);
			temp += ans.get(0)+" "+ans.get(1);
			System.out.println(temp);
			bw.write(temp);
			bw.newLine();
		}
		
		bw.close();	
	}

}
