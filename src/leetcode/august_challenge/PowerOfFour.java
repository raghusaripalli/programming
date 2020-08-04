package leetcode.august_challenge;

public class PowerOfFour {

    private boolean isPowerOfFour(int num) {
        return (num != 0) && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        PowerOfFour p4 = new PowerOfFour();
        boolean res;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            res = p4.isPowerOfFour(i);
            if (res) System.out.println(i);
        }
    }
}
