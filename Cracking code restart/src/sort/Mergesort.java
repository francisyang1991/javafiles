package sort;

public class Mergesort {

	public int[] numbers;
	public int[] helper;
	int number;
	
	public void mergesort(int low,int high){
		
		if (low < high){
			int middle = (low + (high - low)/2);
			
			mergesort(low,middle);
			mergesort(middle+1,high);
			
			merge(low,middle,high);
		}
	}
	
	public void merge(int low,int middle, int high){
		for (int i = 0;i<5;i++){
			System.out.print(numbers[i]+"  ");
			
		}
		System.out.println();
		System.out.println();
		for (int i = low; i <= high; i++) {
		      helper[i] = numbers[i];
		    }
		int i = low;
	    int j = middle + 1;
	    int k = low;
	    
	    while (i<= middle && j <= high){
	    	
	    	if(helper[i]<= helper[j]){
	    		numbers[k] = helper[i];
	    		i++;
	    	}
	    	else {
	    		
	    		numbers[k] = helper[j];
	    		j++;
	    	}
	    	
	    	k++;
	    	
	    }
	    
	    while (i <= middle) {
	        numbers[k] = helper[i];
	        k++;
	        i++;
	      }  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,3,1,5,4};
		
		Mergesort ms = new Mergesort();
		ms.numbers = arr;
		ms.number = arr.length;
		ms.helper = new int[ms.number];
		ms.mergesort(0, ms.number-1);
		
		
		for (int i = 0;i<5;i++){
			System.out.println(ms.numbers[i]);
			
		}
		
	}

}
