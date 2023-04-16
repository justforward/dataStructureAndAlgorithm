package 题库.bit.leetcode_bank;

/*
    题目：给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

    思路：
        1) 等差数列求和
        2）位运算
            将所有数和当前所在的index进行异或操作，那么剩下的就是缺失的数字
 */
public class leetcode_268 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        leetcode_268 l = new leetcode_268();
        System.out.println(l.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int bit = 0;
        for (int i = 0; i < n; i++) {
            bit ^= nums[i] ^ i;
        }
        // 和新补的索引n进行操作
        bit ^= n;
        return bit;
    }
}
