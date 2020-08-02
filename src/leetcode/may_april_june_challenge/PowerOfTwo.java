package leetcode.may_april_june_challenge;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        PowerOfTwo two = new PowerOfTwo();
        System.out.println(two.isPowerOfTwo(Integer.MIN_VALUE));
        System.out.println(two.isPowerOfTwo(-2));
        System.out.println(two.isPowerOfTwo(-1));
        System.out.println(two.isPowerOfTwo(0));
        System.out.println(two.isPowerOfTwo(1));
        System.out.println(two.isPowerOfTwo(16));
        System.out.println(two.isPowerOfTwo(218));
        System.out.println(two.isPowerOfTwo(Integer.MAX_VALUE));
    }
}
