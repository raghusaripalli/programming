package leetcode.august_challenge;

public class SumOfLeftLeaves {
    private int sum;

    private int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        if (root != null)
            dfs(root);
        return sum;
    }

    private TreeNode dfs(TreeNode node) {
        if (node != null) {
            TreeNode left = dfs(node.left);
            dfs(node.right);
            if (left != null && left.left == null && left.right == null)
                sum += left.val;
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves sol = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(sol.sumOfLeftLeaves(root)); // 9 + 15 = 24
    }
}
