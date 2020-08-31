package leetcode.august_challenge;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.val = successor(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private int successor(TreeNode root) {
        return root.left == null ? root.val : successor(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        DeleteNodeInBST deleteNodeInBST = new DeleteNodeInBST();
        deleteNodeInBST.deleteNode(root, 3);
    }
}
