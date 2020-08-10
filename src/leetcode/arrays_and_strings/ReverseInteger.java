package leetcode.arrays_and_strings;

public class ReverseInteger {
    private int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        int rem;
        long sum = 0;
        while (x > 0) {
            rem = x % 10;
            sum = sum * 10 + rem;
            if (sum > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        int res = (int) sum;
        return neg ? -res : res;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1));
        System.out.println(reverseInteger.reverse(0));
        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(-11111110));
        System.out.println(reverseInteger.reverse(1534236469));
    }
}
