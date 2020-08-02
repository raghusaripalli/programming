package leetcode.biweekly_31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoodSplit {
    public int numSplits(String s) {
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        char[] chas = s.toCharArray();
        for (char ch: chas) {
            right.put(ch, right.getOrDefault(ch, 0) + 1);
        }
        int res = 0;
        for (char ch: chas) {
            left.add(ch);
            int count = right.getOrDefault(ch, -1);
            if (count == 1) right.remove(ch);
            else if (count > 1) right.put(ch, count - 1);
            if (left.size()==right.size()) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        GoodSplit gs = new GoodSplit();
        System.out.println(gs.numSplits("aacaba"));
        System.out.println(gs.numSplits("abcd"));
        System.out.println(gs.numSplits("aaaaa"));
        System.out.println(gs.numSplits("acbadbaada"));
    }
}
