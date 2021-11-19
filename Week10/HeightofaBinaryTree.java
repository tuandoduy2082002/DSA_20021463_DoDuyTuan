package Week10;

public class HeightofaBinaryTree {
	public static int helper(Node root) {
		if(root == null)
			return 0;
		return Math.max(helper(root.left),helper(root.right)) + 1;
	}
	
	public static int height(Node root) {
		return helper(root) -1;
	}
}
