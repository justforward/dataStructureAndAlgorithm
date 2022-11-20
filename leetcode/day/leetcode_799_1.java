package leetcode.day;

/*
 线性dp：
    使用dp[i][j] 表示第i行 第j列 杯子的容量
    那么 流向下一个的杯子容量是 当前杯子的容量-1


 */
public class leetcode_799_1 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 10][query_glass + 10];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i][j] <= 1) continue;
                dp[i + 1][j] += (dp[i][j] - 1) / 2 * 0.1;
                dp[i + 1][j + 1] += (dp[i][j] - 1) / 2 * 0.1;
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }

        public double champagneTower1(int poured, int query_row, int query_glass) {
            double[][] dp = new double[query_row + 10][query_row + 10];
            dp[0][0] = poured;
            // 其中第几行 当前行就有多少个杯子 从0 开始
            for (int i = 0; i <= query_row; i++) {
                for (int j = 0; j <= i; j++) {
                    if (dp[i][j] <= 1) continue;
                    dp[i + 1][j] += (dp[i][j] - 1) / 2;
                    dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
                }
            }
            return Math.min(dp[query_row][query_glass], 1);
        }


}
