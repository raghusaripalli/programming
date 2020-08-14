package leetcode.august_challenge;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        int even = 0, odd = 0;
        for (int i = 65; i < 128; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
                arr[i]--;
            }
            even += arr[i];
        }
        return even + ((odd > 0) ? 1 : 0);
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome(""));
        System.out.println(lp.longestPalindrome("abccccba"));
        System.out.println(lp.longestPalindrome("abccccdd"));
    }
}
