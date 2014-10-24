package dataStruct;

public class list {
	public ListNode head;
	public int size;
	
	public list(){
		head = null;
		size = 0;
	}
	
	public void addTail(int data){
		
		ListNode p = new ListNode(0);
		if (head == null)
			head = new ListNode(data);
		else {
		p = head;
		
		while (p.next!=null){
			p = p.next;
		}
		
		p.next = new ListNode(data); 
		}
		size++;
	}
	
	
	public void print(ListNode head){
		ListNode p  =new ListNode(0);
		p = head;
		System.out.println("the list is :");
		while (p!=null){
			System.out.print(p.data+" ");
			p = p.next;
		}
		System.out.println();
	}
	
	    public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null)
	            return head;
	        ListNode f = head.next.next;
	        ListNode p = head;
	        while (f != null && f.next != null) {
	            p = p.next;
	            f =  f.next.next;
	        }
	        ListNode h2 = sortList(p.next);
	        p.next = null;
	        return merge(sortList(head), h2);
	    }
	    
	    public ListNode merge(ListNode h1, ListNode h2) {
	        ListNode hn = new ListNode(Integer.MIN_VALUE);
	        ListNode c = hn;
	        while (h1 != null && h2 != null) {
	            if (h1.data < h2.data) {
	                c.next = h1;
	                h1 = h1.next;
	            }
	            else {
	                c.next = h2;
	                h2 = h2.next;
	            }
	            c = c.next;
	        }
	        if (h1 != null)
	            c.next = h1;
	        if (h2 != null)
	            c.next = h2;
	        return hn.next;
	    }
	}

