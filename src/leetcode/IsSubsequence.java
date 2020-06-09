package leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sidx = 0, tsize = t.length(), size = s.length();
        for (int i = 0; i < tsize && sidx < size; i++) {
            if (t.charAt(i) == s.charAt(sidx)) sidx++;
        }
        return sidx == size;
    }

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(subsequence.isSubsequence("axc", "ahbgdc"));
    }
}
