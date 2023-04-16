package 题库.day;


/*
    计算所有数组两两之间的欧几里得距离

    1、简单模拟，模拟一个棋盘，找到在这些点上的最大信号量，按照每个点对其进行的贡献

    对于一个点来说，最远距离不超过50
    110*110的格子

 */
public class leetcode_1620 {
    public static void main(String[] args) {
        leetcode_1620 leetcode_1620 = new leetcode_1620();
        int[][] towers = new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int radius = 2;
        int[] ints = leetcode_1620.bestCoordinate(towers, radius);
        System.out.println(ints[0]);
        System.out.println(ints[1]);

    }


    //
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] p = new int[110][110];
        int len = towers.length;
        int ans_x = 0, ans_y = 0, ans = 0;
        for (int i = 0; i < len; i++) {
            int x = towers[i][0];
            int y = towers[i][1];
            int num = towers[i][2];
            for (int m = Math.max(0, x - radius); m <= x + radius; m++) {
                for (int n = Math.max(0, y - radius); n <= y + radius; n++) {
                    // 判断当前点的
                    int sub_x = (x - m);
                    int sub_y = (y - n);
                    double sqrt = Math.sqrt(sub_x * sub_x + sub_y * sub_y);
                    if (sqrt > radius) {
                        continue;
                    }
                    p[m][n] += (int) (num / (1 + sqrt));
                    if (ans < p[m][n]) {
                        ans_x = m;
                        ans_y = n;
                        ans = p[m][n];
                    } else if (ans == p[m][n]) {
                        // 字典序里面的最值
                        if ((ans_x > m) || (ans_x == m && ans_y > n)) {
                            ans_x = m;
                            ans_y = n;
                        }
                    }

                }
            }

        }

        return new int[]{ans_x, ans_y};
    }

}
