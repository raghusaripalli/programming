package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int count;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value);
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else
            node.value = value;
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {

    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.count;
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        return node == null ? null : node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return node;
        int compare = key.compareTo(node.key);
        if (compare == 0) return node;
        if (compare < 0) return floor(node.left, key);
        Node temp = floor(node.right, key);
        return temp != null ? temp : node;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node node, Queue<Key> queue) {
        if (node != null) {
            inorder(node.left, queue);
            queue.add(node.key);
            inorder(node.right, queue);
        }

    }
}
