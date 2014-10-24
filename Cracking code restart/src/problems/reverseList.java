package problems;

import dataStruct.ListNode;
import dataStruct.list;

public class reverseList {

	public static ListNode reverseList(ListNode head,int m, int n){
		
		if (head == null || head.next == null) return head;
		if (m ==n ) return head;
		
		ListNode p = new ListNode(0);
		ListNode p1 = new ListNode(0);
		
		p.next = head;
		p1 = p;
		
		for (int i = 1;i<m;i++){
			p = p.next;
		}
		//System.out.println(p.data);
				
		ListNode p3 = p.next;
		for (int i = m;i<n;i++){
			ListNode temp = p3.next.next;
			
			p3.next.next = p.next;
			p.next = p3.next;
			p3.next = temp;		
		}	
		return p1.next;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list l = new list();
		
		for (int i= 1;i<=10;i++){
			l.addTail(i);
		}
		
		l.print(l.head);
		
		l.head = reverseList(l.head,3,10);
		l.print(l.head);
		
		
		
	}

}
