package leetcode.august_challenge;

public class ExcelColumnNumber {
    private static int[] powers = new int[7];

    static {
        powers[0] = 1;
        for (int i = 1; i < 7; i++) {
            powers[i] = powers[i - 1] * 26;
        }
    }

    private int titleToNumber(String s) {
        int res = 0;
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            int val = (s.charAt(i) - 65) + 1;
            res += (val * powers[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        ExcelColumnNumber columnNumber = new ExcelColumnNumber();
        System.out.println(columnNumber.titleToNumber("A"));
        System.out.println(columnNumber.titleToNumber("Z"));
        System.out.println(columnNumber.titleToNumber("AA"));
        System.out.println(columnNumber.titleToNumber("ZY"));
        System.out.println(columnNumber.titleToNumber("ZZ"));
        System.out.println(columnNumber.titleToNumber("AAA"));
        System.out.println(columnNumber.titleToNumber("ZAY"));
        System.out.println(columnNumber.titleToNumber("FXSHRXW"));
    }
}
