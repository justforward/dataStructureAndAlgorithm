package leetcode.offer.P动态规划;

/**
 * @author tandi
 * @date 2023/3/14 下午9:14
 */
public class offer_89 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
