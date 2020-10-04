package leetcode.contest_209;

import leetcode.august_challenge.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return true;
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
        for (int i = 0; i < res.size(); i += 2) {
            List<Integer> level = res.get(i);
            for (Integer integer : level) {
                if (integer %2 == 0) {
                    return false;
                }
            }
            for (int j = 1; j < level.size(); j++) {
                int a = level.get(j - 1);
                int b = level.get(j);
                if (a >= b) {
                    return false;
                }
            }
        }
        for (int i = 1; i < res.size(); i += 2) {
            List<Integer> level = res.get(i);
            for (Integer integer : level) {
                if (integer %2 != 0) {
                    return false;
                }
            }
            for (int j = 1; j < level.size(); j++) {
                int a = level.get(j);
                int b = level.get(j - 1);
                if (a >= b) {
                    return false;
                }
            }
        }
        return true;
    }
}
