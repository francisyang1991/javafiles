package problems;

class Node{
	
	public Node(Object object, int i) {
		// TODO Auto-generated constructor stub
		
	}
	TreeNode node;
	int level;
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}


public class findDeepestNodeInBinaryTree {

	
	public static Node find(TreeNode tn){
		
		if (tn == null){
			Node nd = new Node(null,0);
			return nd;
		}
		
		else {
			Node lnode = find(tn.left);
			Node rnode = find(tn.right);
			Node node = lnode.level<rnode.level ? lnode:rnode;
			node.level++;
			
			if(node.node == null){
				node.node = tn;
			}
			return node;
			
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
