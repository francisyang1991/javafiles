package problems;

import java.util.ArrayList;

public class candy {

	 public static int candy(int[] ratings) {
		 
		 int people = ratings.length;
	        if (people == 0) return 0;
	        if (people == 1) return 1;
	        int[] candies = new int[people];

	        int first = 0;
	        boolean up = false;
	        boolean down = false;
	        int mid = first;
	        int second = first;
	        boolean go_on = false;
	        int current = 0;
	        int next_first = 0;

	        do {
	            // first = 0;
	            candies[first] = 1;
	            up = false;
	            down = false;
	            mid = first;
	            second = first;
	            current = first;

	            while ((++current) < people
	                && ratings[current] > ratings[current - 1]) {
	                up = true;
	                candies[current] = candies[current - 1] + 1;
	            }

	            if (current == people) {
	                mid = current - 1;
	                second = mid;
	                down = false;
	                go_on = false;
	            } else {
	                mid = current - 1;

	                if (ratings[current] == ratings[current - 1]) {
	                    down = false;
	                    second = mid;
	                    next_first = mid + 1;
	                    go_on = true;
	                } else {
	                    down = true;
	                    while ((++current) < people
	                        && ratings[current] < ratings[current - 1]);
	                    second = current - 1;
	                    candies[second] = 1;
	                    if (current == people) {
	                        go_on = false;
	                    } else {
	                        if (ratings[current] == ratings[current - 1]) {
	                            second = current;
	                        }
	                        go_on = true;
	                        next_first = second;
	                    }
	                }
	            }

	            if (down == true) {
	                for (int i = second - 1; i > mid; i--) {
	                    candies[i] = candies[i + 1] + 1;
	                }
	                if (up == true) {
	                    candies[mid] = Math.max(candies[mid - 1], candies[mid + 1]) + 1;
	                } else {
	                    candies[mid] = candies[mid + 1] + 1;
	                }
	            }

	            first = next_first;
	        } while(go_on);

	        int sum = 0;
	        for (int i = 0; i < people; i++) {
	            sum += candies[i];
	        }
	        return sum;  
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,3,2,1,3,1};
		
		System.out.println(candy(arr));
		
	}

}
