package leetcode.arrays_and_strings;

import leetcode.may_april_june_challenge.Helper;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    // 43ms
    public int maxCoins1(int[] piles) {
        Arrays.sort(piles);
        int bob = 0, alice = piles.length - 1;
        int me = alice - 1, res = 0;
        while (bob < me) {
            res += piles[me];
            bob++;
            alice = me - 1;
            me = alice - 1;
        }
        return res;
    }

    // 25ms
    public int maxCoins(int[] piles) {
        int ans = 0;
        Arrays.sort(piles);
        for (int i = piles.length / 3; i < piles.length; i += 2) ans += piles[i];
        return ans;
    }

    public static void main(String[] args) {
        MaximumNumberOfCoinsYouCanGet mn = new MaximumNumberOfCoinsYouCanGet();
        System.out.println(mn.maxCoins(Helper.parseIntegerArray("[2,4,1,2,7,8]")));
        System.out.println(mn.maxCoins(Helper.parseIntegerArray("[2,4,5]")));
        System.out.println(mn.maxCoins(Helper.parseIntegerArray("[9,8,7,6,5,1,2,3,4]")));
    }
}
