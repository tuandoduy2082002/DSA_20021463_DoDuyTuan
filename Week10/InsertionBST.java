package Week10;

public class InsertionBST {

	// Approach 1: Recursive
	public static Node recursive(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		if (data < root.data) {
			root.left = recursive(root.left,data);
		} else {
			root.right = recursive(root.right,data);
		}
		return root;
	}

	// Approach 2: Iterator
	public static Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);
		Node cur = root;
		while (true) {
			if (cur.data <= data) {
				if (cur.right != null)
					cur = cur.right;
				else {
					cur.right = new Node(data);
					break;
				}
			} else {
				if (cur.left != null)
					cur = cur.left;
				else {
					cur.left = new Node(data);
					break;
				}
			}
		}
		return root;
	}

}
