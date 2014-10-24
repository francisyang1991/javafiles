package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class combinationsum {
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	    Arrays.sort(candidates);
	    addUp(candidates, 0, target, new ArrayList<Integer>(), results);
	    HashMap<ArrayList<Integer>,Integer> hs =new HashMap<ArrayList<Integer>,Integer>();
	    
	    for (int i = 0;i<results.size();i++){
			ArrayList<Integer> list = results.get(i);
			if (!hs.containsKey(list)){
				hs.put(list, 1);
				lists.add(list);
			}		
		}
	    
	    
	    return lists;
	}

	private static void addUp(int[] candidates, int start, int target, ArrayList<Integer> path,
	        ArrayList<ArrayList<Integer>> results) {
		if (target == 0){
			ArrayList<Integer> res = new ArrayList<Integer>(path);
	        results.add(res);
	        return;
		}
	    if (start < 0 || start >= candidates.length || target < 0)  return;

	    if (0 == target) {
	        ArrayList<Integer> res = new ArrayList<Integer>(path);
	        results.add(res);
	    } else {
	        for (int i=start; i<candidates.length; ++i) {
	            if (candidates[i] > target)  continue; // we cannot break since data may not be sorted
	            path.add(candidates[i]);
	            addUp(candidates, i+1, target - candidates[i], path, results);
	            path.remove(path.size() - 1);
	        }
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,1,2,7,6,1,5};
		int[] arr2 = {1};
		ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

		lists = combinationSum(arr2,1);
		
		for (int i = 0;i<lists.size();i++){
			ArrayList<Integer> list = lists.get(i);
			for (int j = 0;j<list.size();j++){
				System.out.print(list.get(j)+" ");
			}
			
			System.out.println();
			
		}
		
	}

}
