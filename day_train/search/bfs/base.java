package day_train.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
    题目：得到岛屿的数量
    迷宫的 bfs和dfs
 */

public class base {

    boolean[][] v;

    public int numIslands(char[][] grid) {
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;
        v = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!v[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;

    }


    // grid 是岛屿，i，j是当前位置，queue存储的是当前层的数据
    public void bfs(char[][] grid, int i, int j) {
        // 上下左右的方向
        int[][] area = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        v[i][j] = true;
        while (!queue.isEmpty()) {
            // 当前层的数据
            int size = queue.size();
            for (int d = 0; d < size; d++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                // 找到 上下左右
                for (int k = 0; k < 4; k++) {
                    int nx = x + area[k][0];
                    int ny = y + area[k][1];
                    // 首先这个点必须要在上下左右的位置
                    if (nx < m && nx >= 0 && ny < n && ny >= 0) {
                        if (!v[nx][ny] && grid[nx][ny] == '1') {
                            queue.offer(new int[]{nx, ny});
                            v[nx][ny] = true;
                        }
                    }

                }
            }
        }
    }
}
