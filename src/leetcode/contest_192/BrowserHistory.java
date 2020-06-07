package leetcode.contest_192;

public class BrowserHistory {
    static class Node {
        String site;
        Node prev, next;

        Node(String site) {
            this.site = site;
        }
    }

    private Node root;

    public BrowserHistory(String homepage) {
        root = new Node(homepage);
    }

    public void visit(String url) {
        root.next = new Node(url);
        root.next.prev = root;
        root = root.next;
    }

    public String back(int steps) {
        while (steps-- != 0 && root.prev != null) {
            root = root.prev;
        }
        return root.site;
    }

    public String forward(int steps) {
        while (steps-- != 0 && root.next != null) {
            root = root.next;
        }
        return root.site;
    }
}
