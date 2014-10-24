package sort;

public class Quicksort {
	
	int[] numbers;
	int number;
	
	public void sort(int[] arr){
		
		if (arr.length == 0 || arr == null){
			return ;
			
		}
		
		this.numbers = arr;
		this.number  = arr.length;
		
		quicksort(0,number-1);
	}
	
	public void quicksort(int low, int high){
		
		int i = low, j = high;
		int pivot = numbers[low + (high - low) / 2];
		
		while (i <= j){
			
			while(numbers[i] < pivot){
				i++;
			}
			while (numbers[j] > pivot){
				j--;
			}
			
			if (i <= j){
				exchange(i,j);
				i++;
				j--;	
			}		
		}
		
		if (low < j)
			quicksort(low,j);
		if (i < high)
			quicksort(i,high);	
	}
	
	public void exchange(int small, int large){
		
		int temp;
		
		temp = numbers[small];
		numbers[small] = numbers[large];
		numbers[large] = temp;
	}
	
	
	
	
	public void printArray(int[] arr){
		
		
		for (int i = 0; i < arr.length; i++){
			
			System.out.println(arr[i]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,4,2,8,6,5,7,3};
		
		Quicksort qsort = new Quicksort();
		qsort.numbers = arr;
		qsort.number = arr.length;
		
		qsort.sort(arr);
		
		for (int i = 0;i<qsort.number;i++){
			System.out.println(qsort.numbers[i]);
			
		}
		
		//System.out.println("BubbleSort:");
		
		
		
		
		
		
	}

}
