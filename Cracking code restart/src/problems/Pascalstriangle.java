package problems;

import java.util.ArrayList;

public class Pascalstriangle {

	
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {
		
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		lists.add(list);
		if (numRows == 1) return lists;
		list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(1);
		
		lists.add(list);
		if (numRows == 2) return lists;
		for (int i =2 ;i<numRows;i++){
			list = lists.get(i-1);
			ArrayList<Integer> newlist = new ArrayList<Integer>();
			newlist.add(list.get(0));
			for (int j = 1;j<list.size();j++){
				newlist.add(list.get(j)+list.get(j-1));
			}
			newlist.add(list.get(list.size()-1));
			
			lists.add(newlist);
		}
		return lists;
        
    }
	
	public static void print(ArrayList<ArrayList<Integer>> lists){
		
		for (ArrayList<Integer> list:lists){
			for (Integer num:list){
				System.out.print(num+" ");
			}
			System.out.println();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		print(generate(4));
		
	}

}
