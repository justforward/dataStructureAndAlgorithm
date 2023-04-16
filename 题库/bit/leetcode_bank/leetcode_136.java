package 题库.bit.leetcode_bank;

/*
    题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    思路：把所有的数字进行异或，成对的数变成0，剩下的就是只出现一次的元素
 */
public class leetcode_136 {
    public int singleNumber(int[] nums) {
        int bit = 0;
        for (int num : nums) {
            bit ^= num;
        }
        return bit;
    }
}
