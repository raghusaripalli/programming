package leetcode.october;

import leetcode.august_challenge.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        int level = 0;
        while (!q1.isEmpty()) {
            int size = q1.size();
            level++;
            while (size-- > 0) {
                TreeNode node = q1.poll();

                assert node != null;
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    q1.add(node.left);
                }
                if (node.right != null) {
                    q1.add(node.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        MinimumDepthofBinaryTree md = new MinimumDepthofBinaryTree();
        System.out.println(md.minDepth(null));
        System.out.println(md.minDepth(new TreeNode()));
    }
}
