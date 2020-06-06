package leetcode;

public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        char a, b;
        for (int i = 0; i < n / 2; i++) {
            a = s[i];
            b = s[n-i-1];
            if (a!=b) {
                s[i] = b;
                s[n-i-1] = a;
            }
        }
    }
}
