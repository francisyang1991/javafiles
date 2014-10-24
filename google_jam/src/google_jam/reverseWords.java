package google_jam;

import java.io.*;
import java.util.ArrayList;

public class reverseWords {

	public static String reverseWords(String s){
		String reverseWord = "";
		int len = s.length();
		if (len == 0) return "";
		StringBuffer sb = new StringBuffer();
		String temp = "";
		boolean first = true;
		boolean isSpace = false;
		for (int i = len-1;i>=0;i--){
			if (s.charAt(i) == ' ' && sb.length() != 0){
				//if (!isSpace) reverseWord +=" ";
				if (first)
					{
					sb.reverse();
					first = false;
					}
				else sb.append(' ').reverse();				
				reverseWord += sb.toString();
				isSpace = true;
				sb = new StringBuffer();
				continue;
			}
			else if (s.charAt(i) != ' '){
				isSpace = false;
				sb.append(s.charAt(i));
			}			
		}
		if (reverseWord.length()>1 && sb.length()>0)
		 reverseWord += sb.append(' ').reverse().toString();
		else if (sb.length()>0 && reverseWord.length()<1)
			return sb.reverse().toString();
		else return reverseWord;
		return reverseWord;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		String inputfilename = "B-large-practice.in.txt";
//		String output = "output.txt";
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
//		
		ArrayList<String> words = new ArrayList<String>();
		//int lines = Integer.parseInt(br.readLine());	
		String line = "  123 456  ";
		
		System.out.println("the answer is ("+reverseWords(line)+")");
//		for (int i = 0;i<lines;i++){
//			String temp = "";
//			line = br.readLine();
//			int number = i+1;
//			temp = "Case #"+number+": "+reverseWords(line);
//			//System.out.println(reverseWords(line));
//			bw.write(temp);
//			bw.newLine();
//		}
		
		
		
		
		
	//	bw.close();
	}

}
