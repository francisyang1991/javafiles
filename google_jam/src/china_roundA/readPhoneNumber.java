package china_roundA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class readPhoneNumber {
	public static String readString(String str){
		StringBuffer sb = new StringBuffer();
		String[] list1 = {" ","double","triple","quadruple","quintuple","sextuple","septuple","octuple","nonuple","decuple","0"};
		String[] list2 = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		
		int len = str.length();
		char c = str.charAt(0);
		int count = 1;
		for(int i = 1;i<len;i++){
			if (str.charAt(i)!=c){
				if (count>=2 && count <=10)
					{
						sb.append(list1[count-1]+" "+list2[c-'0']);
						sb.append(' ');
						//System.out.println(sb.toString());
					}
				else if (count <2){
					sb.append(list2[c-'0']);
					sb.append(' ');
					//System.out.println(sb.toString());
				}
				else {
					for (int k = 0;k<count-1;k++){
						sb.append(list2[c-'0']);
						sb.append(' ');
					}
					sb.append(list2[c-'0']);
				}
				
				c = str.charAt(i);
				count = 1;
			}
			else {
				count++;
			}
		}
		if (count>=2 && count<=10)
		{
			sb.append(list1[count-1]+" "+list2[c-'0']);
			//System.out.println(sb.toString());
		}
	else if (count <2){
		sb.append(list2[c-'0']);
		//System.out.println(sb.toString());
	}
	else {
		for (int k = 0;k<count-1;k++){
			sb.append(list2[c-'0']);
			sb.append(' ');
		}
		sb.append(list2[c-'0']);
	}
		
		
		//System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	public static String readPhoneNumber(String src,String[] format){
		StringBuffer sb = new StringBuffer();
		int lenformat = format.length;
		int begin = 0;
		for (int i = 0; i<lenformat;i++){
			int l = Integer.parseInt(format[i]);
				if (i != lenformat-1){
					String subString = src.substring(begin, begin+l);
					System.out.println("the substring is " + subString);
					begin = begin+l;
					sb.append(readString(subString));
					sb.append(' ');
					System.out.println(sb.toString());
				}
				else {
					String subString = src.substring(begin);
					sb.append(readString(subString));
					System.out.println(sb.toString());
				}
		}
		
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputfilename = "A-large-practice.in.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		
		
		//readPhoneNumber(0000000000,);
		
		
		ArrayList<String> words = new ArrayList<String>();
		int lines = Integer.parseInt(br.readLine());	
		String line = "";
		for (int i = 0;i<lines;i++){
			String temp = "";
			line = br.readLine();
			String[] s = line.split(" ");
			int number = i+1;
			String phonenumber = s[0];
			String[] format = s[1].split("-");
				
			temp = "Case #"+number+": "+readPhoneNumber(phonenumber,format);
			System.out.println(temp);
	    
			bw.write(temp);
			bw.newLine();
		}	
		bw.close();
		
		
//		String ss = "lines";
//		System.out.println(ss.substring(4, 6));
	}

}
