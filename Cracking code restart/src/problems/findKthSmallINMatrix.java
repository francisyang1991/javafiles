package problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.text.html.MinimalHTMLWriter;

class HeapNode{
	int val;
	int x;
	int y;
	
	HeapNode(int val,int x, int y){
		this.val = val;
		this.x = x;
		this.y = y;
	}
	
}


public class findKthSmallINMatrix {

	public static void swap(HeapNode[] harr,int x, int y){
		HeapNode temp = harr[x];
		harr[x] = harr[y];
		harr[y] = temp;
		
	}
		
	public static void minHeapify(HeapNode[] harr, int index,int heap_size){
		
		int l = index*2+1;
		int r = index*2+2;
		int smaller = index;
		if (l<heap_size && harr[l].val < harr[index].val ){
			smaller = l;
		}
		if (r<heap_size && harr[r].val < harr[smaller].val ){
			smaller = r;
		}
		if (smaller !=index){
			swap(harr,index,smaller);
			minHeapify(harr, smaller, heap_size);
		}
		
	}
	
	public static void  buildHeap(HeapNode[] harr, int n){
		int i = (n-1)/2;
		
		while (i>=0){
			minHeapify(harr, i, n);
			i--;
		}
		
		
	}
	
	public static int find(int[][] arr,int k){
		
		int ans = 0;
		int len = arr[0].length;
		
		if (k <=0 || k > len*len) return -1;
		
		HeapNode[] harr = new HeapNode[len];
		for (int i= 0; i< len;i++){
			harr[i] = new HeapNode(arr[0][i],0,i);
		}
		buildHeap(harr, len);
		
		HeapNode hr = new HeapNode(0,0,0);
		
		for (int i= 0;i < k;i++){
			hr = harr[0];
			int nextVal;
			if (hr.x < len-1){
				nextVal = arr[hr.x+1][hr.y];
			}
			else nextVal = Integer.MAX_VALUE;
			
			HeapNode tem = new HeapNode(nextVal,(hr.x)+1,hr.y);
			harr[0] = tem;
			minHeapify(harr, 0, len);
		}
		
		return hr.val;
		
	}
	
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
		int mat[][] = { {10, 10, 30, 40},
		                {10, 25, 35, 45},
		                {25, 29, 37, 48},
		                {32, 33, 39, 50},
              };
		System.out.println("the answer");
		System.out.println(find(mat, 3));
		
		StringBuffer s = new StringBuffer("abc");
		Stack<String> st = new Stack<String>();
		Queue<String> qu = new LinkedList<String>();
		List<String>  li = new LinkedList<String>();
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		char c = 'a';
		
		HashMap<Character, Integer> hs1 = new HashMap<Character, Integer>();

		//List<Integer[]> intlist = ArrayList<Integer[]>();
		String str = "abcdef";
		System.out.println(str.substring(0, 1));
		int tmp = 'z'-c;
		s.setCharAt(0, (char)('a'+1));
		System.out.println(s.toString());
	}

	

}
