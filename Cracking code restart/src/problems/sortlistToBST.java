package problems;

import dataStruct.ListNode;
import dataStruct.TreeNode;
import dataStruct.list;

public class sortlistToBST {
	
	public static TreeNode sortedListToBST(ListNode head) {
        
		int n  =countLNodes(head);
		return helper(head,0,n-1);
		
		
    }
	
	public static int countLNodes(ListNode head){
		int ans = 0;
		while (head!=null){
			ans++;
			head = head.next;
		}
		return ans;
	}
	
	
	public static TreeNode helper(ListNode head,int start, int end){
		if (end < start) return null;
		
		int mid = start + (end -start)/2;
		TreeNode left = helper(head,start,mid-1);
		
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		
		head = head.next;
		
		root.right = helper(head,mid+1,end);
		return root;
		
		
	}
	public static void printTree(TreeNode root){
		
		if (root == null) return;
		else {
			printTree(root.left);
			System.out.print(root.data+" ");
			printTree(root.right);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list l = new list();
		
		//int[] a ={4,19,14,5,-3,1,8,5,11,15};
		for (int i= 1;i<8;i++){
			l.addTail(i);
		}
		
		TreeNode root  = null;
		root = sortedListToBST(l.head);
		
		printTree(root);
		
	}

}
