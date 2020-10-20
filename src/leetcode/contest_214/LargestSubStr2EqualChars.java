package leetcode.contest_214;

public class LargestSubStr2EqualChars {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        int l = s.length();
        char init, end;
        for (int i = 0; i < l; i++) {
            init = s.charAt(i);
            for (int j = i + 1; j < l; j++) {
                end = s.charAt(j);
                if (init == end) {
                    res = Math.max(j - i - 1, res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestSubStr2EqualChars ls = new LargestSubStr2EqualChars();
        System.out.println(ls.maxLengthBetweenEqualCharacters("abbca"));
    }
}
