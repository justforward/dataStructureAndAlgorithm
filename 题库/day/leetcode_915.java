package 题库.day;

/*
    找到最小值 然后左右指针？进栈 查看值
    // 从右边找到第一个比它小的值
 */
public class leetcode_915 {
    public static void main(String[] args) {
        leetcode_915 leetcode_915 = new leetcode_915();

        int[] nums = new int[]{29, 33, 6, 4, 42, 0, 10, 22, 62, 16, 46, 75, 100, 67, 70, 74, 87, 69, 73, 88};
        System.out.println(leetcode_915.partitionDisjoint(nums));
    }


    public int partitionDisjoint(int[] nums) {
        // 维护后缀的最小值
        int n = nums.length;
        int[] mi = new int[n + 1];
        mi[n] = nums[n - 1];
        for (int i = n - 1; i >= 0; --i) {
            mi[i] = Math.min(nums[i], mi[i + 1]);
        }

        // 维护前缀的最大值
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int v = nums[i - 1];
            max = Math.max(max, v);
            if (max <= mi[i]) {
                return i;
            }
        }

        return -1;

    }
}
