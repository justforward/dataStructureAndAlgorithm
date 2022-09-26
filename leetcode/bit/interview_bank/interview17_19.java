package leetcode.bit.interview_bank;

/*
    https://leetcode.cn/problems/missing-two-lcci/
    题目：给定一个数组，包含从 1 到 N 所有的整数，
         但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？

    思路：1) 位运算 ^
         2）将题目变成只寻找确实的一个数的数组。
 */
public class interview17_19 {
    public static void main(String[] args) {
        int i = 10;

        System.out.println(i & (-i));
    }

    public int[] missingTwo(int[] nums) {
        // 补全当前这个位
        int n = nums.length;
        int bit = 0;
        // 首先对所有nums进行异或
        for (int num : nums) bit ^= num;
        for (int i = 1; i <= n + 2; i++) {
            // 从补全的地方进行异或
            bit ^= i;
        }

        // 有两个数是不相等的 至少有一位是1
        // 将数组进行切分，每个数组都包含了一个缺失的数

        return new int[]{};

    }
}
