package china_roundA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sorting {

	public static ArrayList<Integer> sorting(ArrayList<Integer> list){
		
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even= new ArrayList<Integer>();
		ArrayList<Integer> ans= new ArrayList<Integer>(list);
		
		
		for (int i =0;i<list.size();i++){
			int num = list.get(i);
			if ( num % 2 == 0)
				even.add(num);
			else odd.add(num);
		}
		
	  Collections.sort(odd);
	  
	  Collections.sort(even,Collections.reverseOrder());
	  int p = 0;
	  int q = 0;
	  for (int i = 0 ;i<ans.size();i++){
		  int num = ans.get(i);
		  if (num % 2 == 0){
			  ans.set(i, even.get(q++));
		  }
		  else 
		  {
			  ans.set(i, odd.get(p++));
		  }
		  
	  }
	  
//	  Collections.sort(list, new Comparator<Long>() {
//		    public int compare(Long o1, Long o2) {
//		        return o2.compareTo(o1);
//		    }
//		});
	  
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputfilename = "C-large-practice.in.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		
		ArrayList<Integer> worth = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int lines = Integer.parseInt(br.readLine());	
		String line = "";
		for (int i = 0;i<lines;i++){
			String temp = "";
			StringBuffer sb = new StringBuffer();
			String str = br.readLine();
			//System.out.println(str);
			int num = Integer.parseInt(str);
			line = br.readLine();
			String[] s = line.split(" ");
			for (int j = 0;j<num;j++){
				worth.add(Integer.parseInt(s[j]));
			}
			
			ans = sorting(worth);
			worth.clear();
			int number = i+1;
			 for (int j = 0;j<num-1;j++){
				 sb.append(ans.get(j));
				 sb.append(' ');
			 }
			 sb.append(ans.get(num-1));
			
			 temp = "Case #"+number+": "+sb.toString();
			 System.out.println(temp);
			bw.write(temp);
			bw.newLine();
		}	
		bw.close();
	}

}
