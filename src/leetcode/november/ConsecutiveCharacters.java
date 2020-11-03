package leetcode.november;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int res = 1, cmax = 0;
        char ch = '0';
        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                cmax++;
            } else {
                ch = s.charAt(i);
                res = Math.max(cmax, res);
                cmax = 1;
            }
        }
        return Math.max(cmax, res);
    }
}
