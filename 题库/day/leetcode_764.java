package 题库.day;

import java.util.*;

/*
    1、暴力求解：
        1)、广度优先遍历
            如果遇到其中一层的某一个数字的上下左右遇到的值出现了0 或者出现了边界 那么直接返回
        2)、每次需要延伸的位置需要记录 上下左右 每一层需要记录四个点
    2、前缀和
        为上、下、左、右四个方向维护一个前缀和矩阵。
        然后针对每个位置，计算其四个方向上的最小值。
        最后遍历所有位置，计算所有位置中的最大值。
    3、对于每个点 记录每个方向的上下左右 dp值，最后取最小值


 */
public class leetcode_764 {

    public static void main(String[] args) {
        leetcode_764 leetcode_764 = new leetcode_764();
        int n = 1;
        int[][] mines = new int[][]{{0, 0}};
        System.out.println(leetcode_764.orderOfLargestPlusSign(n, mines));
    }

    /*
        记录四个方向1的个数，然后计算出四个方向的最小值
        01110110 从左到右为 01230120 从右到左 03210210 得到当前值下面的最小值

     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<Integer>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0; /* left */
            for (int j = 0; j < n; j++) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0; /* right */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0; /* up */
            for (int j = 0; j < n; j++) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0; /* down */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }


    public int[][] bound = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    // 只有这个mines的元素为0
    public int orderOfLargestPlusSign1(int n, int[][] mines) {

        // 构建gird[n][n]
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 1;
            }
        }

        for (int[] nums : mines) {
            grid[nums[0]][nums[1]] = 0;
        }


        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, BFS(i, j, grid, n));
                }
            }
        }
        return ans;
    }

    public int BFS(int i, int j, int[][] mines, int len) {
        int ans = 1;
        Queue<int[]> queue = new LinkedList<>();
        for (int index = 0; index < 4; index++) {
            int m = i + bound[index][0];
            int n = j + bound[index][1];
            if (m < 0 || m >= len || n < 0 || n >= len || mines[m][n] == 0) {
                return ans;
            }
            if (mines[m][n] == 1) {
                queue.add(new int[]{m, n});
            }
        }
        ans++;

        while (!queue.isEmpty()) {
            for (int index = 0; index < 4; index++) {
                int[] poll = queue.poll();
                int first = poll[0];
                int second = poll[1];
                int m = first + bound[index][0];
                int n = second + bound[index][1];
                if (m < 0 || m >= len || n < 0 || n >= len || mines[m][n] == 0) {
                    return ans;
                }
                if (mines[m][n] == 1) {
                    queue.add(new int[]{m, n});
                }
            }
            ans++;
        }

        return ans;
    }
}
