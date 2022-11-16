package leetcode.offer;


/*
    子矩阵的求和：
        而这四个大矩阵有一个共同的特点，就是左上角都是 (0, 0) 原点。
        四个
 */
public class offer_013 {


    // 二维矩阵求和
    class NumMatrix {

        int[][] preSum;// 记录（0，0） 到（i-1,j-1）的前缀和

        // 矩阵的初始化
        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            if (m == 0 || n == 0) return;
            preSum = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 每次计算一个小的格子
                    // 计算每个矩阵中 0，0 到当前坐标下的前缀和
                    preSum[i][j] = matrix[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 求子数组中的
            return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
        }
    }
}
