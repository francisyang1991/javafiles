package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class generateParentheses {

	public static ArrayList<String> generateParenthesis(int n) {
		 
		ArrayList<String> list = new ArrayList<String>();
		return helper(n,list);
		
	}
	
	
	public static String insertString(String str,int n,String str2){
		StringBuffer sb = new StringBuffer(str);
		sb.insert(n, str2);
		
		return sb.toString();
	}
	public static ArrayList<String> helper(int n, ArrayList<String> list) {
		if (n == 1) {
			list.add("()");
			return list;
		}
		else {
			ArrayList<String> ll = helper(n-1,list);
			String str = "";
			ArrayList<String> newlist = new ArrayList<String>();
			HashMap<String,Integer> hs = new HashMap<String,Integer>();
			for (int i = 0;i<ll.size();i++){
				str = ll.get(i);
				for (int j = 0;j<str.length();j++){
					String news = insertString(str,j,"()");
					
					if (hs.containsKey(news))
						continue;
					else {
						hs.put(news,1);
						newlist.add(news);
						System.out.println(news);
					}
				}			
			}
			return newlist;
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(3);
		int[] prices = new int[100];
		int max = Integer.MIN_VALUE;
	}

}
