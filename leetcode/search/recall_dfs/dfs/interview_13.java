package leetcode.search.recall_dfs.dfs;

/*
    题目：
        地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
        一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
        也不能进入行坐标和列坐标的数位之和大于k的格子。
        例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
        请问该机器人能够到达多少个格子？

    思路：出现有障碍物的机器人移动，直接backTraced()

    1）回溯和dfs
      回溯算法是在遍历「树枝」，DFS 算法是在遍历「节点」，

      回溯算法是找到所有的可行解？dfs是找到一个可行的解即可。

      dfs和回溯法其主要的区别是：回溯法在求解过程中不保留完整的树结构，而深度优先搜索则记下完整的搜索树。


   2） 回溯算法

     解决一个回溯问题，实际上就是一个决策树的遍历过程，站在回溯树的一个节点上，你只需要思考 3 个问题：

    1、路径：也就是已经做出的选择。
    2、选择列表：也就是你当前可以做的选择。
    3、结束条件：也就是到达决策树底层，无法再做选择的条件。

    3）dfs
      直接按照一个方向进行移动，每次移动的方向就是一个选择
 */

public class interview_13 {
    public int movingCount(int m, int n, int k) {
        // 用于标记当前的点是否被访问过
        boolean[][] visited = new boolean[m][n];
        // 只往右、下移动
        return backTraced(visited, 0, 0, m, n, k);
    }

    public int backTraced(boolean[][] v, int i, int j, int m, int n, int k) {
        if (i >= m || j >= n || v[i][j] || isValid(i) + isValid(j) > k) return 0;
        v[i][j] = true;
        return 1 + backTraced(v, i + 1, j, m, n, k) + backTraced(v, i, j + 1, m, n, k);
    }

    public int isValid(int index) {
        int sum = 0;
        while (index > 0) {
            sum += index % 10;
            index /= 10;
        }
        return sum;
    }
}


