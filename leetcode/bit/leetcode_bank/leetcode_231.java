package leetcode.bit.leetcode_bank;

/*
    题目：判断某个数是否是2的次幂

    思路：2的次幂一定是某一位是1 其他位都为0
 */
public class leetcode_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
