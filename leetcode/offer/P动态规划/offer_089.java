package leetcode.offer.P动态规划;


//dp[i] 每个房子的金额
// https://leetcode.cn/problems/Gu0c2T/solution/ru-he-xiang-chu-zhuang-tai-ding-yi-he-zh-8zrv/
public class offer_089 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        // 打劫完最后一个房间
        for (int i = 2; i <= nums.length; i++) {
            // 这个
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        }
        return dp[nums.length];
    }
}


