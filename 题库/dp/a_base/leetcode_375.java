package 题库.dp.a_base;

/*
    1）dfs 记忆搜索
    2）区间dp
     区间类动态规划是线性动态规划的扩展，
     它在分阶段地划分问题时，与阶段中元素出现的顺序和由前一阶段的哪些元素合并而来有很大的关系。

     cost是将两组元素合并起来的代价

     从左端得到


 */
public class leetcode_375 {
    int[][] cache = new int[201][201];

    public int getMoneyAmount(int n) {
        return dfs(1, n);
    }

    public int dfs(int l, int r) {
        if (l <= r) {
            return 0;
        }

        if (cache[l][r] != 0) return cache[l][r];

        int ans = Integer.MAX_VALUE;

        for (int i = l; i <= r; i++) {
            // 当选择的数位 i 时，至少需要 cur 才能猜中数字
            int cur = Math.max(dfs(l, i - 1), dfs(i + 1, r)) + i;
            ans = Math.min(ans, cur);
        }

        cache[l][r] = ans;
        return ans;
    }

    // 区间dp

    public int getMoneyAmount1(int n) {
        int[][] f = new int[n + 10][n + 10];
        // 每次的长度 长度从2开始
        for (int len = 2; len <= n; len++) {

            for (int l = 1; l + len - 1 <= n; l++) {
                // len=r-l+1 所以r=l+len-1
                int r = l + len - 1;
                // 计算这个区间值 首先设定一个最大值
                f[l][r] = 0x3f3f3f3f;
                // x 是l 和 r移动的数字 所以f[l][r]的值会随着x的移动进行变化
                for (int x = l; x <= r; x++) {
                    // 选择这个区间的最大值，然后加上现在选择的这个点
                    int cur = Math.max(f[l][x - 1], f[x + 1][r]) + x;
                    f[l][r] = Math.min(f[l][r], cur);
                }
            }
        }
        return f[1][n];
    }

    public void example(int n) {
        int[][] f = new int[n + 10][n + 10];
        int[] sum = new int[n];
        for (int len = 1; len <= n; len++) {
            // 找到l
            for (int l = 1; l + len - 1 <= n; l++) {
                // 得到r len=r-l+1
                int r = l + len - 1;
                // 每次变动的k 所以f[l][r]的值需要改变？
                f[l][r] = Integer.MIN_VALUE;
                for (int k = l; k <= r; k++) {
                    // 需要将r 到l的value 加上
                    f[l][r] = Math.max(f[l][r], f[l][k] + f[k + 1][r] + sum[r] - sum[l - 1]);
                }

            }
        }
    }
}
