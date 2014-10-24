package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class anagrams {

	public static String sort(String str){
		String s = "";
		
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		String sorted =new  String(chars);
		
		return sorted;
		
		
	}
	public static ArrayList<String> anagrams(String[] strs) {
        
		ArrayList<String> ans = new ArrayList<String>();
		HashMap<String,ArrayList<String>> hs = new HashMap<String,ArrayList<String>>();
		
		for (int i =0;i<strs.length;i++){
			String x = strs[i];
			String sortX = sort(x);
			if (!hs.containsKey(sortX)){
				ArrayList<String> newstr = new ArrayList<String>();
				newstr.add(x);
				hs.put(sortX, newstr);
			}
			else {
				ArrayList<String> exist = hs.get(sortX);
				exist.add(x);
				hs.put(sortX, exist);
			}
		}
		
		for (String key:hs.keySet()){
			ArrayList<String> list = hs.get(key);
			if (list.size()>1)
				ans.addAll(list);
		}
		return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"and","dna","ans","tea","eat"};
		
		ArrayList<String> ans = new ArrayList<String>();
		ans = anagrams(arr);
		
		for (String str : ans){
			System.out.println(str);
		}
		
		
		
	}

}
