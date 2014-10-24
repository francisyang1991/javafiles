package problems;

import dataStruct.ListNode;
import dataStruct.list;

public class insertionSort {
public static ListNode insertsort(ListNode head){
		
	if (head == null || head.next == null)
		return head;

	ListNode newHead = new ListNode(head.val);
	ListNode pointer = head.next;

	// loop through each element in the list
	while (pointer != null) {
		// insert this element to the new list

		ListNode innerPointer = newHead;
		ListNode next = pointer.next;

		if (pointer.val <= newHead.val) {
			ListNode oldHead = newHead;
			newHead = pointer;
			newHead.next = oldHead;
		} else {
			while (innerPointer.next != null) {

				if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
					ListNode oldNext = innerPointer.next;
					innerPointer.next = pointer;
					pointer.next = oldNext;
				}

				innerPointer = innerPointer.next;
			}

			if (innerPointer.next == null && pointer.val > innerPointer.val) {
				innerPointer.next = pointer;
				pointer.next = null;
			}
		}

		// finally
		pointer = next;
	}

	return newHead;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list l = new list();
		
		int[] a ={4,19,14,5,-3,1,8,5,11,15};
		for (int i= 0;i<a.length;i++){
			l.addTail(a[i]);
		}
		
		//l.print(l.head);
		
		l.head = insertsort(l.head);
		l.print(l.head);
	}

}
