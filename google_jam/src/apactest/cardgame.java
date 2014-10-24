package apactest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class cardgame {

	
	
	public static int cardgame(int k,ArrayList<Integer> arr){
		
		int left = arr.size();
		int len = left;
		boolean found = false;
		int i = 0;
		while (!found && arr.size()>2){
			
			int a = arr.get(i);
			int b = arr.get(i+1);
			int c = arr.get(i+2);
			
			if (a+c == 2*b){
				found = false;
				arr.remove(i);	
				arr.remove(i);	
				arr.remove(i);
				i = 0;
			}
			else {
				i++;
				if (i > arr.size()-3){
					break;
				}
				
			}
			
		}
				
		return arr.size();
	}
	
	public static void shiftArr(int[] arr, int index){
		
		
		for (int i = index ; i<arr.length;i++){
			arr[index] = arr[index+3];
			arr[index+1] = arr[index+4];
			arr[index+2] = arr[index+5];					
		}	
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String inputfilename = "A-small-attempt0.in-2.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		
		
		//readPhoneNumber(0000000000,);
//		int[] arr = {4,4,3,3,3,4};
//		ArrayList<Integer> array1 = new ArrayList<Integer>();
//		array1.add(4);
//		array1.add(4);
//		array1.add(3);
//		array1.add(3);
//		array1.add(3);
//		array1.add(4);
		
		
		//System.out.println(cardgame(15, array1));
		
		int number = 0;
		int lines = Integer.parseInt(br.readLine());	
		String line = "";
		for (int i = 0;i<lines;i++){
			String temp = "";
			line = br.readLine();
			String[] s = line.split(" ");
			
			number = i + 1;
			int m = Integer.parseInt(s[0]);	
			int n = Integer.parseInt(s[1]);	
				
			line = br.readLine();
			s = line.split(" ");
			int[] arr1 = new int[s.length];
			
			ArrayList<Integer> array = new ArrayList<Integer>();
			for (int j = 0;j < s.length; j++){
				arr1[j] = Integer.parseInt(s[j]);	
				array.add(arr1[j]);
			}
					
			temp = "Case #"+number+": "+cardgame(n,array);
			System.out.println(temp);
	    
			bw.write(temp);
			bw.newLine();
		}	
		bw.close();
		
		
		
		
		
	}

}
