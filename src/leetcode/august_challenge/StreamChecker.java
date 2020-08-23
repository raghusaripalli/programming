package leetcode.august_challenge;

class StreamChecker {

    private final Trie root;
    private final StringBuilder sb;
    private static final char baseChar = 'a';

    class Trie {
        Trie[] child;
        boolean end;

        Trie() {
            this.end = false;
            child = new Trie[26];
        }
    }

    private void insert(String word) {
        int idx;
        Trie cur = root, next;
        for (int i = word.length() - 1; i >= 0; i--) {
            idx = word.charAt(i) - baseChar;
            next = cur.child[idx];
            if (next == null) {
                next = new Trie();
                cur.child[idx] = next;
            }
            cur = next;
        }
        cur.end = true;
    }

    public StreamChecker(String[] words) {
        root = new Trie();
        sb = new StringBuilder();
        for (String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        int idx;
        Trie cur = root, next;
        for (int i = sb.length() - 1; i >= 0; i--) {
            idx = sb.charAt(i) - baseChar;
            next = cur.child[idx];
            if (next == null)
                break;
            if (next.end)
                return true;
            cur = next;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = new String[3];
        words[0] = "cd";
        words[1] = "f";
        words[2] = "kl";
        StreamChecker checker = new StreamChecker(words);
        for (int i = 97; i <= 118; i++) {
            char c = (char) i;
            System.out.println(c + ": " + checker.query(c));
        }
    }
}