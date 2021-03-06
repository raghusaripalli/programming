package leetcode.september;

import leetcode.may_april_june_challenge.Helper;

public class BestTimeToBuyAndSellStock {
    private int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int globMax = 0, currMax = 0;
        for (int i = 1; i < prices.length; i++) {
            currMax = Math.max(0, currMax + (prices[i] - prices[i - 1]));
            globMax = Math.max(globMax, currMax);
        }
        return globMax;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();
        System.out.println(bt.maxProfit(Helper.parseIntegerArray("[7,1,5,3,6,4]")));
        System.out.println(bt.maxProfit(Helper.parseIntegerArray("[7,6,4,3,1]")));
    }
}
