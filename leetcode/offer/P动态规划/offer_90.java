package leetcode.offer.P动态规划;

/**
 * @author tandi
 * @date 2023/3/14 下午9:27
 */
public class offer_90 {
    public int rob(int[] nums) {
        int n = nums.length;
        // 找到排序后的最大值
        if (n <= 3) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }
        return Math.max(call(nums, 0, n - 1), call(nums, 1, n));
    }

    public int call(int[] nums, int l, int r) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[l] = 0;
        dp[l + 1] = nums[l];
        for (int i = l + 2; i <= r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[r];
    }
}
