package problems;


import dataStruct.ListNode;
import dataStruct.list;


public class deletenthlast {

public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow.next = head;
        
        if (head.next == null ) return null;
        
       for(int i = 0;i<n;i++){
           if (slow == null) return null;
           slow = slow.next;
       }
        
        if (slow == null) return null;
        
        fast.next = head;
        while (slow.next !=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        if (fast.next == head) return head.next;
        ListNode temp = new ListNode(0);
        
        temp = fast.next.next;
        fast.next = temp;
        
        return head;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
            list l = new list();

            int[] a ={1,2};
            for (int i= 0;i<a.length;i++){
                l.addTail(a[i]);
            }

                    l.print(l.head);

                    l.head = removeNthFromEnd(l.head,2);
                    l.print(l.head);

                }

    }
