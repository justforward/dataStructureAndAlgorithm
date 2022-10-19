package leetcode.dp.a_base;
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
}
