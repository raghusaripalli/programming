package leetcode.august_challenge;

public class ValidPalindrome {

    private boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char left = Character.toLowerCase(s.charAt(l));
            char right = Character.toLowerCase(s.charAt(r));

            boolean leftAlphaNum = Character.isAlphabetic(left) | Character.isDigit(left);
            boolean rightAlphaNum = Character.isAlphabetic(right) | Character.isDigit(right);

            if (!leftAlphaNum) {
                l++;
            }
            if (!rightAlphaNum) {
                r--;
            }
            if (leftAlphaNum && rightAlphaNum) {
                if (left != right)
                    return false;
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindrome("0P"));
    }
}
