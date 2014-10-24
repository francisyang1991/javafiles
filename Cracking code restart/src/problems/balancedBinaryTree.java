package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import dataStruct.TreeNode;

public class balancedBinaryTree {

	public static TreeNode createMinimalBST(int[] arr){
		
		return createMinimalBST(arr,0,arr.length-1);
	}

	
	public static TreeNode createMinimalBST(int[] arr,int start, int end){
		if (end < start)
			return null;
		
		int mid = (start + end ) /2;
		TreeNode n  = new TreeNode(arr[mid]);
		
		n.right = createMinimalBST(arr,mid+1,end);
		n.left = createMinimalBST(arr,start,mid-1);
		
		return n;
			
	}
	
	public static void createZigzagLevelLinkedList(TreeNode root,
			ArrayList<LinkedList<TreeNode>> lists,int level){
		if (root == null)
			return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level){
			list  = new LinkedList<TreeNode>();
			lists.add(list);
			}
		else {
			list = lists.get(level);
		}
		list.add(root);
		if (level % 2 == 0){
		createLevelLinkedList(root.left,lists,level+1);
		createLevelLinkedList(root.right,lists,level+1);
		}
		else {
			createLevelLinkedList(root.right,lists,level+1);
			createLevelLinkedList(root.left,lists,level+1);
			
			
		}
	}
	
	public static void createLevelLinkedList(TreeNode root,
			ArrayList<LinkedList<TreeNode>> lists,int level){
		if (root == null)
			return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level){
			list  = new LinkedList<TreeNode>();
			lists.add(list);
			}
		else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left,lists,level+1);
		createLevelLinkedList(root.right,lists,level+1);
	}
	
	public static void createLevelLinkedList(TreeNode root,
		    ArrayList<LinkedList<TreeNode>> lists,ArrayList<ArrayList<Integer>> listsnum,int level){
				if (root == null)
					return;
				LinkedList<TreeNode> list = null;
				ArrayList<Integer> nums = null;
				if (lists.size() == level){
					list  = new LinkedList<TreeNode>();
					nums = new ArrayList<Integer>();
					lists.add(list);
					listsnum.add(nums);
					}
				else {
					list = lists.get(level);
					nums = listsnum.get(level);
				}
				list.add(root);
				nums.add(root.val);
				createLevelLinkedList(root.left,lists,listsnum,level+1);
				createLevelLinkedList(root.right,lists,listsnum,level+1);
		    }
	
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListIterative(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root!=null) current.add(root);
		
		while (current.size()>0){
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			
			for (TreeNode n:parents){
				if (n.left != null){
					current.add(n.left);
				}
				if (n.right != null){
					current.add(n.right);
				}
			}
		}
		
		return result;
		
		
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root,lists,0);
		System.out.println();
		for (LinkedList<TreeNode> li:lists){
			printList(li);
		}
		
		return lists;	
	}
	
	public static ArrayList<ArrayList<Integer>> createZigzagLevelLinkedList(TreeNode root){
		
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		ArrayList<ArrayList<Integer>> lists1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> listsnum = new ArrayList<ArrayList<Integer>>();
        if (root == null) return listsnum;
        
		createLevelLinkedList(root,lists,listsnum,0);
		
		System.out.println();
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		for (ArrayList<Integer> li:listsnum){
			if (listsnum.indexOf(li) % 2 != 0){
			for (int i = li.size()-1;i>=0;i--){
				s.add(li.get(i));
			}
			lists1.add(s);
			printList(s);
			s.clear();
			}
			else {
			printList(li);
			lists1.add(li);		
			}
		}
		
		return lists1;	
	}
	
	public static boolean checkBST(TreeNode root,int min,int max){
		if (root == null)  return true;
			
		if (root.data <=min || root.data> max)
			return false;
		if (!checkBST(root.left,min,root.data)||!checkBST(root.right,root.data,max))
			return false;
		return true;
		
	}
	
	public static boolean checkBST(TreeNode root){
		return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static void printList(LinkedList<TreeNode> list){
		
		
		for (TreeNode n:list){
			System.out.print(n.data+" ");
		}
		System.out.println();
		
	}
	
	public static void printList(ArrayList<Integer> list){
		
		
		for (Integer n:list){
			System.out.print(n+" ");
		}
		System.out.println();
		
	}
	
	public static void printTree(TreeNode root){
		
		if (root == null) return;
		else {
			printTree(root.left);
			System.out.print(root.data+" ");
			printTree(root.right);
		}	
	}
	
	public static ArrayList<Integer> postorderTraversal(TreeNode root){
		
		ArrayList<Integer> tree = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode tn = root;	
		TreeNode lv = null;
		TreeNode peekNode = null;
		System.out.println();
		//st.push(root);
		while (!st.isEmpty()|| tn!=null){	
			if (tn!= null){
				st.push(tn);
				tn = tn.left;
			}
			else {
				peekNode = st.peek();
				if (peekNode.right!=null && lv!= peekNode.right)
					tn = peekNode.right;	
				else { 
					st.pop();
					tree.add(peekNode.data);
					System.out.print(peekNode.data+" ");
					lv = peekNode;			
		        }
			}
		}
		System.out.println();
		return tree;
		
	}
	
	public static TreeNode findChild(TreeNode root,int target){
		LinkedList<TreeNode> qu = new LinkedList<TreeNode>();
		if (root == null)
			return null;
		qu.addFirst(root);
		if (root.val == target)
			return root;
		while (!qu.isEmpty()){
			TreeNode head = qu.pop();
			if (head.val == target)
				return head;
			else {  
				if (head.left != null){
					qu.addLast(head.left);
				}
				if (head.right != null){
					qu.addLast(head.right);
				}
			}
		}
		return null;
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int[] a = new int[n];
		
		for (int i = 0;i<n;i++){
			a[i] = i+1;
		}
		
		
		TreeNode root = createMinimalBST(a);
		
		printTree(root);
		
		TreeNode ans = findChild(root,10);
		
		//System.out.println(ans.val);
		//postorderTraversal(root);
		
		
		//System.out.println(checkBST(root));
		createZigzagLevelLinkedList(root);
		//createLevelLinkedList(root);
	}

}
