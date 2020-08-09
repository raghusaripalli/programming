package leetcode.trees;

import leetcode.august_challenge.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            inorder(root.left, nodes);
            nodes.add(root.val);
            inorder(root.right, nodes);
        }
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return nodes;
    }

    private List<Integer> inorderTraversalIterative(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nodes.add(cur.val);
            cur = cur.right;
        }
        return nodes;
    }

    public static void main(String[] args) {
        BinaryTreeTraversal treeTraversal = new BinaryTreeTraversal();

        // Test 1
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = treeTraversal.inorderTraversal(root);
        res.forEach(x -> System.out.print(x + " "));
        System.out.println();

        res = treeTraversal.inorderTraversalIterative(root);
        res.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
