package dataStruct;

import java.util.Arrays;

public class TheQueue {

	private int[] queueArray;
	
	private int queueSize = 0;
	
	private int head,rear,length = 0;
	
	TheQueue(int size){
		
		queueArray = new int[size];
		
		queueSize = size;
		
		Arrays.fill(queueArray, -1);
	}
	
	
	public void insert(int data){
		
		if(length + 1 <= queueSize){
			
			rear++;
			
			queueArray[rear] = data;
			
			length++;
			
			System.out.println("Insert: "+ data);
		}
		
		else {
			
			System.out.println("Sorry but the queue is full.");
		}
	}
	
	public void remove(){
		
		if (length > 0){
			
			System.out.println("Remove: "+ queueArray[head]);
			
			queueArray[head] = -1;
			
			head++;
			
			length--;
			
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
