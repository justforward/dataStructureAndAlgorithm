package 题库.day;

/*
    1）动态规划：状态机dp
        dp[i][j]
        i是进行交换的数组下标，j代表 0代表交换 1代表不交换
        仅需考虑交换当前位置后，当前元素与前后元素大小关系变化即可。

        又因为我们会从前往后处理每个位置，因此只需要考虑当前位置与前一位置的大小关系即可。
    2）dp定义
    定义 f[i][j] 为考虑下标范围为 [0,i] 的元素，
    且位置 i 的交换状态为 j 时（其中 j=0 为不交换，j=1 为交换）两数组满足严格递增的最小交换次数。

    min(f[i][0],f[i][1]) 取最小交换次数即可

    查看前一个元素对当前元素的影响
 */
public class leetcode_801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] f = new int[n][2];
        for (int i = 1; i < n; i++)
            f[i][0] = f[i][1] = n + 10;
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                f[i][0] = f[i - 1][0];
                f[i][1] = f[i - 1][1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                f[i][0] = Math.min(f[i][0], f[i - 1][1]);
                f[i][1] = Math.min(f[i][1], f[i - 1][0] + 1);
            }
        }
        return Math.min(f[n - 1][0], f[n - 1][1]);
    }
}
