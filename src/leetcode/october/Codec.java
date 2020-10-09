package leetcode.october;

import leetcode.august_challenge.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize (TreeNode root) {
        if (root == null)
            return "";
        return String.valueOf (root.val) + "," + serialize (root.left) + "," + serialize (root.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize (String data) {
        String[] S = data.split (",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(S));
        return deserializeUtil (queue);
    }

    public TreeNode deserializeUtil (Queue <String> queue) {
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s.equals (""))
                return null;
            TreeNode node = new TreeNode (Integer.parseInt(s));
            node.left = deserializeUtil (queue);
            node.right = deserializeUtil (queue);
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        String serializedTree = codec.serialize(root);
        System.out.println(serializedTree);
        TreeNode deserializedTree = codec.deserialize(serializedTree);
        System.out.println(codec.serialize(deserializedTree));
    }
}
