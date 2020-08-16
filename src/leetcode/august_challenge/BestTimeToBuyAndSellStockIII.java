package leetcode.august_challenge;

import leetcode.may_april_june_challenge.Helper;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int s1 = -prices[0], s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s1 = Math.max(s1, -prices[i]);
            s2 = Math.max(s2, s1 + prices[i]);
            s3 = Math.max(s3, s2 - prices[i]);
            s4 = Math.max(s4, s3 + prices[i]);
        }

        return Math.max(0, s4);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII stock = new BestTimeToBuyAndSellStockIII();
        System.out.println(stock.maxProfit(Helper.parseIntegerArray("[3,3,5,0,0,3,1,4]")));
        System.out.println(stock.maxProfit(Helper.parseIntegerArray("[1,2,3,4,5]")));
        System.out.println(stock.maxProfit(Helper.parseIntegerArray("[7,6,4,3,1]")));
    }
}
