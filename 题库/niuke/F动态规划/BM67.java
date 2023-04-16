package 题库.niuke.F动态规划;

/**
 * @author tandi
 * @date 2023/3/20 下午10:01
 */
public class BM67 {

    // dp[i][j] 是到坐标点ij的总路径个数
    public int uniquePaths(int m, int n) {
        // write code here
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }


}
