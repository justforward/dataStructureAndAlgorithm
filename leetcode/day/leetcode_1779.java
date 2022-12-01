package leetcode.day;

public class leetcode_1779 {
    public static void main(String[] args) {
        leetcode_1779 leetcode_1779 = new leetcode_1779();
        int x = 3, y = 4;

       // int[][] points = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        int[][] points = new int[][]{{2,3}};
        System.out.println(leetcode_1779.nearestValidPoint(x, y, points));
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int sub = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int f = point[0];
            int s = point[1];
            if (f == x || s == y) {
                int tmp = Math.abs(x - f) + Math.abs(s - y);
                if (tmp < sub) {
                    sub = tmp;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
