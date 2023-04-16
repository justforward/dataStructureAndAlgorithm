package 题库.offer.P动态规划;

/*
       dp[i] 到达该阶梯需要花费的体力
     第三个阶梯 的两种方式
     dp[3]=dp[2]+cost[2];
     dp[3]=dp[1]+cost[1];

     1)初始的位置是不需要记录体力的
     2）要走完最后一个楼梯才算走完
 */
public class offer_088 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 选择下标为0的作为初始台阶，
        dp[0] = 0;
        dp[1] = 0;
        // 要走完最后一个楼梯才算走完
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
