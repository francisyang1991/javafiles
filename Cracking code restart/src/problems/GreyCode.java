package problems;

import java.util.ArrayList;

public class GreyCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		ArrayList<Integer> arr = new ArrayList<Integer>();
	    arr.add(0);
	    for(int i=0;i<n;i++){
	        int inc = 1<<i;
	        for(int j=arr.size()-1;j>=0;j--){
	            arr.add(arr.get(j)+inc);
	        }
	    }
	    		
	}

}
