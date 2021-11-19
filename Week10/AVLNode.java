package Week10;

public class AVLNode {
    int val;
    int ht;
    AVLNode left;
    AVLNode right;

    public AVLNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        ht = 0;
    }

    static int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.ht;
    }

}