public class InvertBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode mirror(TreeNode root) {
        if (root==null) return root;

        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        return mirror(root);
    }
}
