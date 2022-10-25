package leetcode.day;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
    从其中一个岛屿为1的位置进行遍历 将0 全部变为1？
    1） 深度搜索找到其中一个岛屿
    2）然后利用广度搜索找到两个岛屿的最短距离

    1）深度遍历的时候，找到所有1的位置，然后根据岛屿的1的位置进行广度搜索

    考虑最小的值？


 */
public class leetcode_934 {
    public int shortestBridge(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Queue<int[]> queue = new LinkedList<>();
                if (grid[i][j] == 1) {
                    // queue 是找到的所有的位置
                    dfs(grid, i, j, queue);
                    int step = 0;
                    while (!queue.isEmpty()) {
                        // 得到第一层的节点
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] cel = queue.poll();
                            int x = cel[0], y = cel[1];
                            // 得到当前位置的上下左右
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                // 判断上下左右是否越界
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                    // 保留下一层的数据
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }

                            }
                        }
                        step++;
                    }
                }
            }
        }

        return 0;

    }


    public void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != 1) {
            return;
        }
        queue.offer(new int[]{i, j});
        grid[i][j] = -1;
        dfs(grid, i - 1, j, queue);
        dfs(grid, i + 1, j, queue);
        dfs(grid, i, j - 1, queue);
        dfs(grid, i, j + 1, queue);
    }
}
