package 题库.动态规划.完全背包;

/**
 * @author tandi
 * @date 2023/4/3 下午9:52
 *  完全背包求组合
 */
public class leetcode_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
