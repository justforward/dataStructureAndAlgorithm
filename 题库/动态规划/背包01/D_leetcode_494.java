package 题库.动态规划.背包01;

/**
 * @author tandi
 * @date 2023/4/2 下午4:35
 */
public class D_leetcode_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 测试用例中出现无法满足的情况下
        if (target < 0 && sum < -target) return 0;

        if ((sum + target) % 2 != 0) return 0;

        int bagWeight = (sum + target) / 2;

        int[] dp = new int[bagWeight + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagWeight; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagWeight];
    }
}
