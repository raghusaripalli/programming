package leetcode.may_april_june_challenge;

public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 cc2 = new CoinChange2();
        int[] coins = new int[3];
        coins[0] = 1;
        coins[1] = 2;
        coins[2] = 5;
        int count = cc2.change(5, coins);
        System.out.println(count);
    }
}
