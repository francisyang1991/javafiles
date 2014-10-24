package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Twosum {

	
	public static int[] sum(int[] numbers,int target){
			
		int head = 0;
        int rear = numbers.length-1;
        int[] ans = new int[2];
        int[] temp = Arrays.copyOf(numbers,numbers.length);
        Arrays.sort(numbers);
        
        while (head != rear){
            
            if (numbers[head] + numbers[rear] > target){
                
                rear--;
            }
            else if (numbers[head] + numbers[rear] < target){
                head++;
                
            }
            else {
                ans[0] = numbers[head];
                ans[1] = numbers[rear];
               break;
            }
                
        }
        boolean flag = true;
        int[] anss = new int[2];
        for (int i = 0;i<temp.length;i++){
            if (temp[i] == ans[0] && flag) 
               {
                   anss[0] = i+1;
                   flag = false;
               }
               
            if (temp[i] == ans[1]) anss[1] = i+1; 
        }
        
        if (anss[0] > anss[1]){
        	int t = anss[0];
        	anss[0] = anss[1];
        	anss[1] = t;
        }
        
          
        return anss;
		
		
	}
	
	
	public static int[] sumBySet(int[] numbers,int target){
		
		int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
		
		
	}
	
	public static void print(int[] arr){
		
		for (int n : arr){
			System.out.println(n);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,75,25};
		
		long start = System.nanoTime();
		print(sum(arr,100));
		
		long end = System.nanoTime();
		System.out.println(end-start);
		

		start = System.nanoTime();
		
		print(sumBySet(arr,100));
		
	    end = System.nanoTime();
		System.out.println(end-start);
		
		
	}

}
