package 题库.bit.interview_bank;

/*
    https://leetcode.cn/problems/missing-two-lcci/
    题目：给定一个数组，包含从 1 到 N 所有的整数，
         但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？

    思路：1) 位运算 ^
         2）将题目变成只寻找缺失一个数的数组。
 */
public class interview17_19 {
    public static void main(String[] args) {
        int i = 10;

        System.out.println(i & (-i));
    }

    public int[] missingTwo(int[] nums) {
        // 补全当前这个位
        int n = nums.length + 2;
        int bit = 0;
        // 首先对所有nums进行异或
        for (int num : nums) bit ^= num;
        for (int i = 1; i <= n; i++) {
            // 从补全的地方进行异或
            bit ^= i;
        }

        // 通过lowbit算法，将原始数组分为两部分，lsb位置为0的一组，lsb位置为1的为一组
        int lsb = (bit == Integer.MIN_VALUE ? bit : bit & (-bit));

        // 根据当前的位对nums进行区分，一个是等于0、一个是等于1
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            // 根据某一位将数据进行区分
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }

        //  将当前的值和n进行异或
        for (int i = 1; i <= n; i++) {
            if ((i & lsb) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }

        return new int[]{type1, type2};
    }
}


