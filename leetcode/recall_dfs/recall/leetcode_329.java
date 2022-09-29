package leetcode.recall_dfs.recall;

/*
    题目：
        找到矩阵中的最长递增（严格递增的）数列。

    思路：记忆搜索 DFS

    通过遍历每个点，去找，但是通过记忆搜索来记录每次已经找到的子递增数列

    vis 数组是为了避免在这次遍历的时候，走回头路，
    第一个问题就是你说的那样 vis数组在dfs中就是为了避免走回头路 而找递增这个条件可以把回头路直接剪枝掉了所以不用vis数组

    DFS就是先一次性搜到底，再退一步，再走另一条路，再一次搜到底。
    DFS属于暴力的搜索？回溯的情况就可以将某个值标记为已经是被使用的，下次操作到该点的时候直接跳过即可？

    回溯是 dfs 的一种表现形式。
        除此之外，dfs 还有另一种表现形式，
        它使用的是局部变量，类似于记忆；而回溯使用的是全局变量。
 */

public class leetcode_329 {

    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        int res = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int backed = backed(matrix, i, j, -1);
                res = Math.max(res, backed);
            }
        }

        return res;
    }

    public int backed(int[][] matrix, int i, int j, int pre) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length ||
                matrix[i][j] <= pre) {
            return 0;
        }

        // 当前节点所在的位置，全部都是上升的
        if (memo[i][j] != 0) return memo[i][j];

        // 得到上下左右的最大值
        int left = backed(matrix, i + 1, j, matrix[i][j]);
        int right = backed(matrix, i - 1, j, matrix[i][j]);
        int up = backed(matrix, i, j + 1, matrix[i][j]);
        int low = backed(matrix, i, j - 1, matrix[i][j]);

        int res = Math.max(Math.max(left, Math.max(right, up)), low) + 1;

        // 记忆递归缓存值
        memo[i][j] = res;
        return res;
    }
}
