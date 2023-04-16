package 题库.动态规划.完全背包;

/**
 * @author tandi
 * @date 2023/4/8 下午9:14
 */
public class leetcode_322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
