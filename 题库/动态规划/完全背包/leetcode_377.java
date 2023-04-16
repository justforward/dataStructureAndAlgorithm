package 题库.动态规划.完全背包;

/**
 * @author tandi
 * @date 2023/4/6 下午9:43
 * 完全背包求排列
 */
public class leetcode_377 {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
