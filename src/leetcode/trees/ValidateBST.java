package leetcode.trees;

import leetcode.august_challenge.TreeNode;

public class ValidateBST {

    private boolean dfs(TreeNode root, long min, long max) {
        if (root != null) {
            if (root.val > min && root.val < max) {
                return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        ValidateBST vb = new ValidateBST();
        System.out.println(vb.isValidBST(new TreeNode(Integer.MAX_VALUE)));
    }
}
