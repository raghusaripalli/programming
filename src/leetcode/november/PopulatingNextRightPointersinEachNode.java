package leetcode.november;


import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node prev = null;
            while (len-- > 0) {
                Node cur = queue.poll();
                if (cur != null)
                    queue.add(cur.left);
                if (cur != null)
                    queue.add(cur.right);
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;
            }
            if (prev != null)
                prev.next = null;
        }
        return root;
    }
}
