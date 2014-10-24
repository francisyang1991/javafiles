package problems;

import java.util.ArrayList;

import java.util.HashMap;

public class palindrome_partitioning {
	public static HashMap<String,ArrayList<ArrayList<String>>> dict = new HashMap<String,ArrayList<ArrayList<String>>>();
	//public ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
	
	public static ArrayList<ArrayList<String>> partition(String s) {
		
		return helper(s);
    }
	public static ArrayList<ArrayList<String>> helper(String str){
		if (dict.containsKey(str))
			return dict.get(str);
		
			
			ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
					
			if (str.length()==0)
				lists.add(new ArrayList<String>());
			else {
				
				for (int i = 1;i<=str.length();i++){
					String subs = str.substring(0, i);
					if (isPalindrome(subs)){
						ArrayList<ArrayList<String>> part = helper(str.substring(i));
					for (ArrayList<String> list :part){
						ArrayList<String> added = new ArrayList<String>(list);
						added.add(0, subs);
						lists.add(added);
					}			
					}
				}				
				}	
			dict.put(str, lists);
			return lists;	
		}
	public static boolean isPalindrome(String s){
		
		int len = s.length();
		int front = 0;
		int rear = len-1;
		while (front<rear){
			if (s.charAt(front)!=s.charAt(rear))
				return false;
			front++;
			rear--;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcba";
		
		//System.out.println(isPalindrome(str));
		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		
		lists = partition(str);
		
		for (int i = 0;i<lists.size();i++){
			for (String sam :lists.get(i)){
				System.out.print(sam+" ");
			}
			System.out.println();
		}
		
		
	}

}
