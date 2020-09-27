package leetcode.september;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfNAryTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // BFS
    public int maxDepth(Node root) {
        int depth = 0;
        if (root == null)
            return depth;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level_size = queue.size();
            while (level_size-- != 0) {
                Node node = queue.poll();
                if (node != null && node.children != null)
                    queue.addAll(node.children);
            }
            depth++;

        }
        return depth;
    }

    public static void main(String[] args) {
        MaximumDepthOfNAryTree md = new MaximumDepthOfNAryTree();
        Node root = new Node(1);
        List<Node> level2 = new ArrayList<>();
        for (int i = 2; i < 5; i++) {
            level2.add(new Node(i));
        }
        root.children = level2;
        List<Node> level3 = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            level3.add(new Node(i));
        }
        level2.get(1).children = level3;
        System.out.println(md.maxDepth(root));
    }
}
