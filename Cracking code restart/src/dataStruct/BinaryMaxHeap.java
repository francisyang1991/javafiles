package dataStruct;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryMaxHeap {

	public int[] data;
	public int items;
	public int heapSize;
	
	BinaryMaxHeap(int size){
		
		data = new int[size];
		
		heapSize = size;
		
		items = 0;

	}
	
	public int getTop(){
		
		if ( items > 0){
			
			return data[0];
		}
		else return -1;
			
	}
	
	public boolean isEmpty(){
		
		return items == 0;
	}
	
	public int getLeftChildIndex(int index){
		
		return 2*index + 1;
	}
	
	public int getRightChildIndex(int index){
		
		return 2*index + 2;
	}
	
	public int getParentIndex(int index){
		
		return (index - 1) >> 1;
	}
	
	public void insert(int node){
		
		if (++items > heapSize ){
			System.out.println("The heap is full!");
			return;
		}
		else {
			data[items-1] = node;
			shiftUp(items-1);
		}
	}
	public void shiftUp(int index){
		
		int parentIndex;	
		if (index != 0){
			parentIndex = getParentIndex(index);		
			if (data[index] > data[parentIndex]){
				swap(index,parentIndex);
				shiftUp(parentIndex);
			}	
		}	
	}
	
	public int delete(int index){		
		if (items <= 0){
			return -1;
		}
		else if (index == items - 1){	
			items--;	
			return data[index];
		}
		else {		
		int temp  = data[index];
		
		swap(index,--items);
		
		shiftDown(index);
		
		return temp;
		
		}
	}
	
	private void shiftDown(int index){
		
		//printHeap();
		
		int leftChildIndex  = getLeftChildIndex(index);
		int rightChildIndex = getRightChildIndex(index);
		int minIndex;
		
		if (rightChildIndex >= items) {
            if (leftChildIndex >= items)
                  return;
            else
                  minIndex = leftChildIndex;
      } else {
            if (data[leftChildIndex] >= data[rightChildIndex])
                  minIndex = leftChildIndex;
            else
                  minIndex = rightChildIndex;
      }
      if (data[index] < data[minIndex]) {
            swap(index,minIndex);
            shiftDown(minIndex);
      }
		
		
	}
	
	public void swap(int i ,int j){
		
		int temp  = data[i];
		data[i]   = data[j];
		data[j]	  = temp;
	}
	
	public void buildMaxHeap(int[] arr){
		
		
		items = arr.length;
		
		
		for (int i = 0;i<items;i++){
			
			data[i] = arr[i];
		}
		
		
		
		for (int i = items/2; i >= 0; i--){
			
			shiftDown(i);
		}
			
	}
	
	public int[] heapSort(){
		
		int len = items;
		int[] temp = Arrays.copyOf(data, heapSize);
		
		int[] ans = new int[items];
		
		for (int i = 0; i < len; i++){
				
			ans[i] = delete(0);
		}
		data = temp;
		items = len;	
		return ans;
		
	}
	
	public void printHeap(){
		System.out.println("The heap :\n");
		
		for (int i = 0; i < heapSize; i++){
			
			System.out.print(data[i]+" ");
		}
		System.out.println();
		System.out.println("The items is "+ items);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {3,1,4,1,5,9,2,6,5,4};
		
		BinaryMaxHeap bmh = new BinaryMaxHeap(arr.length*2);
		bmh.buildMaxHeap(arr);
		
		bmh.printHeap();
		
		bmh.insert(10);
		bmh.insert(20);
		bmh.insert(13);
		//bmh.delete(0);
		
		System.out.println("Heap Sort: \n");
		int[] sorted = bmh.heapSort();
		for (int i = 0;i <sorted.length;i++){
			
			System.out.print(sorted[i]+" ");
		}
		System.out.println();
		
		bmh.printHeap();
		
		
		
	}

}
