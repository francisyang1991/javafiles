package apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class b {
	
	
	
	static void printbyte(byte[] bb){
		for (int i = 0;i<bb.length;i++){
			System.out.printf("%02X",bb[i]);  
		}
	}
	
	public static String solve(String str) throws UnsupportedEncodingException{
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		System.out.println(str.length());
		byte[] bytes = str.getBytes("UTF-8"); 
		int blen = bytes.length;
		int slen = str.length();
		printbyte(bytes);	
		System.out.println();
		//System.out.println(newString);
		
		for (int i=0;i<bytes.length;i++){
			byte ch = bytes[i];
			if (ch == '@' || ch == '.'){
				if (sb2.length() != 0){
					sb.append(sb2.toString());
				}
				sb2 = new StringBuffer();
				sb.append((char)ch);
				
			}
			else {
				if (ch>=65 && ch<=90){
					sb.append((char)ch+32);
					System.out.println((char)ch+32);
				}
				else if (ch>=97 && ch<=122){
					sb.append((char)ch);
					System.out.println((char)ch);
				}
			}
		
			if (ch < 0) {
				
				//sb2.append(position);
				sb2.append(String.format("%02X",ch));
				System.out.printf("%02X",ch);
			}
		}
		System.out.println(sb.toString());
		//sb.append(str);
		

		
		return sb.toString();
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String inputfilename = "A-small-attempt0.in-2.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		
		
		
		
		//System.out.println(cardgame(15, array1));
//		String line = "";
//		while((line=br.readLine())!=null && line.length()!=0){
//	    
//			bw.write(solve(line));
//			System.out.println(solve(line));
//			bw.newLine();		
//		}	

		bw.close();
		solve("▊▇▄▅@▜.▖");
		
		
		
		
	}

}
