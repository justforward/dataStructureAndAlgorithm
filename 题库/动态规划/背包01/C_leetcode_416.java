package 题库.动态规划.背包01;

/**
 * @author tandi
 * @date 2023/4/2 下午3:01
 */
public class C_leetcode_416 {


    // 1、dp[i] 当背包为i的时候，装入的最大重量为dp[i]
    // 2、递推公式 dp[i]=math.max(dp[i],dp[i-nums[i]]+nums[i])


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        int bagWeight = sum / 2;

        int[] dp = new int[bagWeight + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = bagWeight; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        if (dp[bagWeight] != bagWeight) {
            return false;
        }
        return true;

    }
}
