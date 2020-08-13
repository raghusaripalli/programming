package leetcode.binary_search;

public class SquareRoot {
    public int mySqrt(int x) {
        int left = 0, right = x + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.mySqrt(0));
        System.out.println(squareRoot.mySqrt(1));
        System.out.println(squareRoot.mySqrt(4));
        System.out.println(squareRoot.mySqrt(8));
    }
}
