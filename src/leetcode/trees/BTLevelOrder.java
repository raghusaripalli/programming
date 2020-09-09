package leetcode.trees;

import leetcode.august_challenge.TreeNode;
import leetcode.may_april_june_challenge.Helper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        BTLevelOrder bt = new BTLevelOrder();
        bt.levelOrder(new TreeNode()).forEach(Helper::prettyPrint);
        bt.levelOrder(new TreeNode(1)).forEach(Helper::prettyPrint);
    }
}
