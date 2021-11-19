package Week10;

public class LowestCommonAncestor {
	public static Node lca(Node root, int v1, int v2) {
      	if (root == null || root.data == v1 || root.data == v2) {
      		return root;
      	}
      	Node left = lca(root.left,v1,v2);
      	Node right = lca(root.right,v1,v2);
      	return left == null ? right : right == null ? left : root;
    }
}
