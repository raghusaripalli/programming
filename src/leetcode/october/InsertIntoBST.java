package leetcode.october;

import leetcode.august_challenge.TreeNode;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        InsertIntoBST ii = new InsertIntoBST();
        System.out.println(ii.insertIntoBST(null, 2).val);
    }
}
