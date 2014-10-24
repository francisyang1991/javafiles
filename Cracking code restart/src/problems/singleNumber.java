package problems;

import java.util.ArrayList;

public class singleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,1,2,3,3,4,5,4,5};
		int answer = 0;
		for (int i :a)
		answer ^=i;
		
		System.out.println(answer);
		
		
		
		
		
		
		
	}

}
