package Week10;

import java.util.Stack;

public class IsThisaBinarySearchTree {

	// Approach 1: recursive checkBST
	Node prev = null;
	
	public boolean checkBST(Node root) {
        if(root == null) {
            return true;
        }
        
        if(checkBST(root.left) && (prev == null || root.data > prev.data)) {
            prev = root;
            return checkBST(root.right);
        }
        
        return false;
    }
	
	// Approach 2: Level Order
	public boolean isValidBST(Node root) {
		   if (root == null) return true;
		   Stack<Node> stack = new Stack<>();
		   Node pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.data <= pre.data) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
		}
}
