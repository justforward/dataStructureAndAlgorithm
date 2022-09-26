package leetcode.bit.leetcode_bank;

/*
    题目：
        编写一个函数，输入是一个无符号整数（以二进制串的形式），
        返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

    思路：利用位运算，n&(n-1) 消除二进制数中的最后一个1
 */
public class leetcode_191 {
    public static void main(String[] args) {

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 一直消除最后一位的1 一直到n变为0为止
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
