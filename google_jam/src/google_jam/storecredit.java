package google_jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class storecredit {

	public static int[] sumnum(int sum,int[] array){
		int[] ans = new int[2];
		int len = array.length;	
			for(int i=0;i<len;i++){
				for (int j = i+1;j<len;j++){
					if (array[i]+ array[j] == sum){
						ans[0] = i+1;
						ans[1] = j+1;
						return ans;
					}
						
				}
			}		
		return ans;
	}
	
	public static int[] sumnumOnln(int sum,int[] a){
		int[] ans = new int[2];
		Arrays.sort(a);
		int close = sum;
		int temp = sum;
		int len = a.length;	
		int front = 0;
		int rear = len-1;
			while (front != rear){
				temp = sum- a[front]- a[rear];
				if (close > temp && temp >=0){
					ans[0] = front;
					ans[1] = rear;
					close = temp;
					front++;
				}
				else if (temp < 0){
					rear--;
				}
				else if (temp > 0){
					front++;
				}
			}		
		return ans;
	}
	public static ArrayList<ArrayList<Integer>> sum4num(int[] num,int target){
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();	
		HashMap<ArrayList<Integer>,Integer> hs = new HashMap<ArrayList<Integer>,Integer>();
		if (num.length<4) return lists;
		Arrays.sort(num);
		for (int j = 0;j<num.length-1;j++){
		for (int i = j+1;i<num.length-2;i++){			
		int sum = target-num[i]-num[j];
		int temp = sum;
		int front = i+1;
		int rear = num.length-1;
		ArrayList<Integer> list = new ArrayList<Integer>();
			while (front != rear){
				temp = sum- num[front]- num[rear];
				if (temp == 0){
					list.add(num[j]);
					list.add(num[i]);
					list.add(num[front]);
					list.add(num[rear]);			
					if (!hs.containsKey(list)){
						lists.add(list);
						hs.put(list, null);					
					}
					list = new ArrayList<Integer>();
					front++;
				}
				else if (temp < 0){
					rear--;
				}
				else if (temp > 0){
					front++;
				}
			}		
			}
		}
		return lists;
	}
	public static ArrayList<ArrayList<Integer>> sum3numOnln(int[] num){
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();	
		HashMap<ArrayList<Integer>,Integer> hs = new HashMap<ArrayList<Integer>,Integer>();
		
		Arrays.sort(num);
		for (int i = 0;i<num.length-1;i++){			
		int sum = 0-num[i];
		int temp = sum;
		int front = i+1;
		int rear = num.length-1;
		ArrayList<Integer> list = new ArrayList<Integer>();
			while (front != rear){
				temp = sum- num[front]- num[rear];
				if (temp == 0){
					list.add(num[i]);
					list.add(num[front]);
					list.add(num[rear]);			
					if (!hs.containsKey(list)){
						lists.add(list);
						hs.put(list, null);					
					}
					list = new ArrayList<Integer>();
					front++;
				}
				else if (temp < 0){
					rear--;
				}
				else if (temp > 0){
					front++;
				}
			}
			
			
		}
		return lists;
	}
	public static int sum3closest(int[] num,int target){	
		Arrays.sort(num);
		int close = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < num.length - 1; i++) {
			int sum = target - num[i];
			int temp = sum;
			int front = i + 1;
			int rear = num.length - 1;
			while (front != rear) {
				temp = sum - num[front] - num[rear];
				if (close > Math.abs(temp) && temp != 0) {
					close = Math.abs(temp);
					ans = sum - temp + num[i];
				} else if (temp == 0) {
					return target;
				}

				if (temp < 0) {
					rear--;
				} else if (temp > 0) {
					front++;
				}

			}

		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputfilename = "A-large-practice.in.txt";
		String output = "output.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputfilename)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (new FileOutputStream(output)));
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> words = new ArrayList<String>();
		int lines = Integer.parseInt(br.readLine());	
		String line = "";
		
		//Integer.parseInt(line.charAt(0));
		
		int sum = 50;
		int[] array = {2,1,14,11,25,21,27,23,34,45,47,53,60,200};
		int[] array1 = {-1,0,1,-1,2,4,-3,5,6};
		int[] array2 = {-2,0,1,-1,2,0};
		int[] array3 = {1,1,-1,-1,3};
		
		lists = sum4num(array2,0);
		
		//System.out.println(sum3closest(array3,-1));
		
		for (int i = 0;i<lists.size();i++){
			ArrayList<Integer> list = lists.get(i);
			for (int j = 0;j<list.size();j++){
				System.out.print(list.get(j)+" ");
			}
			
			System.out.println();
			
		}
		
		
		
//System.out.println(ans[0]+" "+ans[1]+ans[2]);
		
//		for (int i = 0;i<lines;i++){
//			
//			String temp = "";
//			
//			int sum = Integer.parseInt(br.readLine());
//			int nums = Integer.parseInt(br.readLine());
//			line = br.readLine();
//			String[] str = line.split(" ");
//			int[] array  = new int[nums];
//			//
//			for (int j = 0;j<nums;j++){
//				array[j] = Integer.parseInt(str[j]);
//			}
//			
//			int[] ans = sumnum(sum,array);
//			int number = i+1;
//			temp = "Case #"+number+": "+ans[0]+" "+ans[1];
//			//System.out.println(reverseWords(line));
//			bw.write(temp);
//			bw.newLine();
//		}
//		
//		bw.close();
	}

}
