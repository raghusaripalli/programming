package leetcode.trees;

import leetcode.august_challenge.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    private int dfsRecursion(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(dfsRecursion(root.left, depth + 1), dfsRecursion(root.right, depth + 1));
    }

    public int maxDepthRecursion(TreeNode root) {
        return dfsRecursion(root, 0);
    }

    public int maxDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree md = new MaximumDepthOfBinaryTree();
        System.out.println(md.maxDepthIterative(new TreeNode(11)));
        System.out.println(md.maxDepthRecursion(new TreeNode(11)));
    }
}
