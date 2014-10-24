package problems;
import java.util.*;

import dataStruct.ListNode;
import dataStruct.list;


public class swapnodesPair {

	
	public static double pow(double x,int n){
		
		if (n == 1) return x;
        if (n == 0) return 1.0;
        if (n < 0 ) return 1/pow(x,0-n);
		else {
			
			double ans = 0;
			int i = 1;
			double temp1,temp2,temp3;
			temp1 = 1;
			temp2 = x;
			while (n >1){
				if (n % 2 == 0){
				temp1 *= temp2*temp2;
				temp2 = temp1;
				n = n/2;
				}
				else {
					n--;
					temp1*=x;
				}
			}
			return temp1;			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list l = new list();
		
		for (int i= 1;i<=10;i++){
			l.addTail(i);
		}
		
		l.print(l.head);
		
		
		
		ListNode helper = new ListNode(0);
        helper.next = l.head;
        ListNode n1 = helper, n2=l.head;
        
        while(n2!=null && n2.next!=null){
            ListNode temp = n2.next.next;
            n2.next.next=n1.next;
            n1.next=n2.next;
            n2.next=temp;
            n1=n2;
            n2=n1.next;
        }
		l.print(helper.next);
		
		System.out.println(pow(0.2,3));
		
		
	}

}
