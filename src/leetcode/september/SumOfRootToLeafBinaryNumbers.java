package leetcode.september;

import leetcode.august_challenge.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    private int total;

    private void traverse(TreeNode root, StringBuffer sb) {
        if (root != null) {
            sb.append(root.val);
            if (root.right == null && root.left == null) {
                total += Integer.parseInt(sb.toString(), 2);
            }
            traverse(root.left, sb);
            traverse(root.right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private int sumRootToLeaf(TreeNode root) {
        total = 0;
        traverse(root, new StringBuffer());
        return total;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        SumOfRootToLeafBinaryNumbers bn = new SumOfRootToLeafBinaryNumbers();
        System.out.println(bn.sumRootToLeaf(root));
    }
}
