package dataStruct;

import java.util.Arrays;

public class TheStack {

	private int[] stackArray;
	
	private int stackSize;
	
	private int topOfStack = -1;
	
	
	TheStack(int size){
		
		stackArray = new int[size];
		
		stackSize  = size;
		
		Arrays.fill(stackArray, -1);
		
	}
	
	public 	void push(int data){
		
		if (topOfStack + 1 < stackSize){
			
			topOfStack++;
			
			stackArray[topOfStack] = data;
			
			
			System.out.println("PUSH: "+ data + " added!");
		}
		else {
			System.out.println("Sorry, Stack is full!");
			
		}
	}
	
	
	public int pop(){
		
		if (topOfStack >= 0){
			
			System.out.println("POP: "+ stackArray[topOfStack]);
			
			stackArray[topOfStack] = -1;
			
			return stackArray[topOfStack--];
		}
		else 
		{
			
			System.out.println("Error: There is no element in the stack!");
			return -1;
		}
		
		
	}
	
	
	
	public int peek(){
		
		System.out.println("Peek: "+ stackArray[topOfStack]);
		return stackArray[topOfStack];
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TheStack st = new TheStack(10);
		
		st.push(12);
		
		st.push(10);
		
		st.peek();
		
		st.pop();
		
		st.peek();
	}

}
