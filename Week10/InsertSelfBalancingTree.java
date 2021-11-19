package Week10;

public class InsertSelfBalancingTree {

    static int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.ht;
    }

    static int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    static AVLNode rightRotate(AVLNode node) {
        AVLNode temp = node.left;
        node.left = temp.right;
        temp.right = node;
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        temp.ht = Math.max(height(temp.left), node.ht) + 1;
        return temp;
    }

    static AVLNode leftRotate(AVLNode node) {
        AVLNode temp = node.right;
        node.right = temp.left;
        temp.left = node;
        node.ht = Math.max(height(node.left), height(node.right)) + 1;
        temp.ht = Math.max(height(temp.right), node.ht) + 1;
        return temp;
    }

    static AVLNode insert(AVLNode root, int val) {
        // insert into self-balancing binary search tree.
        if (root == null) {
            return new AVLNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        root.ht = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }
        if (balance < -1 && val > root.right.val) {
            return leftRotate(root);
        }
        if (balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    static void inorder(AVLNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    static void levelOrder(AVLNode root) {
        if (root == null) {
            return;
        }
        java.util.Queue<AVLNode> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                AVLNode temp = queue.remove();
                System.out.print(temp.val + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // create a self-balancing binary search tree
        AVLNode root = null;
        root = insert(root, 3);
        root = insert(root, 2);
        root = insert(root, 5);
        root = insert(root, 4);
        root = insert(root, 6);
        // print tree
        System.out.println("Inorder traversal of the constructed AVL tree is: ");
        levelOrder(root);
    }

}