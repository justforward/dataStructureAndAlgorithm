package 题库.interview;

/*
    题目：
        连通性，找到所有上下左右全为0的数组

    标签：前缀和 + 动态规划
    思路：
        1）前缀和？二维矩阵的前缀和
            矩阵的前缀和是当前位置和其上下左右进行的？
        2）
 */
public class i_17_23 {


    // 前缀和
    public int[] findSquare_one(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sums = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 二维数组的前缀和？
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int[] res = new int[3];
        int maxSize = 0;
        for (int row1 = 0; row1 < m; row1++) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int size = 0; row1 + size < m && col1 + size < n; size++) {

                    if (matrix[row1][col1] == 1) break;
                    int row2 = row1 + size;
                    int col2 = col1 + size;
                    // 得到bottom
                    int bottom = sums[row2 + 1][col2 + 1] - sums[row2][col2 + 1] - sums[row2 + 1][col1] + sums[row2][col1];
                    int top = sums[row1 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row1 + 1][col1] + sums[row1][col1];
                    int left = sums[row2 + 1][col1 + 1] - sums[row2 + 1][col1] - sums[row1][col1 + 1] + sums[row1][col1];
                    int right = sums[row2 + 1][col2 + 1] - sums[row2 + 1][col2] - sums[row1][col2 + 1] + sums[row1][col2];
                    // 这里加到的数字全部为0
                    if (top == 0 && bottom == 0 && left == 0 && right == 0) {
                        if (size + 1 > maxSize) {
                            res[0] = row1;
                            res[1] = col1;
                            res[2] = size + 1;
                            maxSize = size + 1;
                        }
                    }
                }
            }
        }
        return maxSize == 0 ? new int[0] : res;
    }

}
