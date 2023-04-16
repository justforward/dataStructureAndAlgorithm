package 题库.动态规划.背包01;

/**
 * @author tandi
 * @date 2023/4/2 下午2:08
 */

// 01 背包问题
public class A_zero_ont_knapsack {

    public int main(int[] weight, int[] value, int bagSize) {
        // dp[i][j] 从物品0~i中获取数据放入重量为j的背包中所得到的最大值

        int m = value.length;
        int n = weight.length + 1;
        int[][] dp = new int[m][n];


        // 剩余的初始化为0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];

        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < value[i]) {

                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        return dp[m][n];
    }


    public void test2(int[] weight, int[] value, int bagSize) {
        int m = weight.length;
        int n = value.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            // 遍历背包的顺序，是倒序的
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }

        }


    }


}
