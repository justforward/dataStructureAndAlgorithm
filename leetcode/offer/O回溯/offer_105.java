package leetcode.offer.O回溯;

/**
 * @author tandi
 * @date 2023/3/14 下午10:42
 */
public class offer_105 {
    int max = 0;
    int cur = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cur = 0;
                    dfs(i, j, grid);
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    public void dfs(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) return;

        if (grid[x][y] == 1) {
            grid[x][y] = 0;
            cur++;
        }
        dfs(x - 1, y, grid);
        dfs(x + 1, y, grid);
        dfs(x, y - 1, grid);
        dfs(x, y + 1, grid);
    }
}
