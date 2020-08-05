package leetcode.design;

class WordDictionaryTrie {

    class Node {
        Node[] nodes = new Node[26];
        boolean end = false;
    }

    Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionaryTrie() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = (int) word.charAt(i) - 97;
            if (temp.nodes[idx] == null) {
                temp.nodes[idx] = new Node();
            }
            temp = temp.nodes[idx];
        }
        temp.end = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(Node node, String word, int k) {
        if (node.end && word.length() == k) {
            return true;
        }
        if (k >= word.length()) {
            return false;
        }
        int idx = (int) word.charAt(k) - 97;
        if (idx == -51) {
            for (int i = 0; i < node.nodes.length; i++) {
                if (node.nodes[i] != null && searchHelper(node.nodes[i], word, k + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.nodes[idx] != null) {
                return searchHelper(node.nodes[idx], word, k + 1);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionaryTrie wd = new WordDictionaryTrie();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.addWord("maddy");
        System.out.println(wd.search("pad")); // false
        System.out.println(wd.search("bad")); // true
        System.out.println(wd.search(".ad")); // true
        System.out.println(wd.search("m..")); // true
        System.out.println(wd.search(".a.d.")); // true
        System.out.println(wd.search("..")); // false
        System.out.println(wd.search("...")); // true
        System.out.println(wd.search("....")); // false
        System.out.println(wd.search("..d..")); // true
        System.out.println(wd.search(".ad")); // true
        System.out.println(wd.search(".a.")); // true
        System.out.println(wd.search("")); // false
    }
}