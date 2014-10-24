package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class permutation {

	public static ArrayList<ArrayList<Integer>> permute(int[] num){
		
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> ans1 = new ArrayList<ArrayList<Integer>>();
	
	ArrayList<Integer> numlist = new ArrayList<Integer>();
	ArrayList<Integer> numlist1 = new ArrayList<Integer>();
	
	int len = num.length;
	if (len == 0)
		return null;
	else if (len == 1){
		numlist.add(num[0]);
		ans.add(numlist);
		return ans;
	}
	else {
		numlist.add(num[0]);
		numlist.add(num[1]);		
		ans.add(numlist);
		numlist1.add(num[1]);
		numlist1.add(num[0]);		
		ans.add(numlist1);
		if (len > 2){
				ans = permutehelper(ans,2,num);
			}	
		}
	return ans;
	}
	
	public static ArrayList<ArrayList<Integer>> permutehelper(ArrayList<ArrayList<Integer>> lists, int number,int[] num){
		
		if (number == num.length)
			return lists;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> ans1 = new ArrayList<ArrayList<Integer>>();		
			//System.out.println("the current number is " + num[number]);
			for (int j = 0; j < lists.size();j++){
				ArrayList<Integer> numlist1 = new ArrayList<Integer>();
				numlist1 = lists.get(j);
				//printlist(numlist1);
				for (int k =0;k<=numlist1.size();k++){
					ArrayList<Integer> numlist2 = new ArrayList<Integer>(numlist1);
					if (k == numlist1.size()) 
						numlist2.add(num[number]);
					else numlist2.add(k, num[number]);
					printlist(numlist2);
					ans1.add(numlist2);	
					
				}			
			}
									
		return permutehelper(ans1,number+1,num);
	}
	
	
	
	
	public static void printlist(ArrayList<Integer> list){
		for (int i = 0 ;i<list.size();i++){
			System.out.print(list.get(i)+ " ");
			
		}
		System.out.println();
	}
	
	public static  String listtostring(ArrayList<Integer> list){
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i<list.size();i++){
			sb.append(list.get(i).toString());
			
			
		}
		
		return sb.toString();
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0,0,2,2,3,3,3};
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		HashMap<String,Integer> hs = new HashMap<String,Integer>();
		list = permute(arr);
		ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0;i<list.size();i++){
			
			ArrayList<Integer> temp = list.get(i);
			
			String str = listtostring(temp);
			if (!hs.containsKey(str)){
				hs.put(str, 1);
				list1.add(temp);
			}
			else {
			continue;
			}
		}
		
		for (int i = 0;i<list1.size();i++){
			
			String str = listtostring(list1.get(i));
			System.out.println(str);
		}
			 
	}

}
