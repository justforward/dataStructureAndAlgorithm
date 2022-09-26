package leetcode.array;

/*
题目：
    给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
思路：
  1）位远算：
    利用异或的性质，出现a^a=0,0^a=a,我们只用分别异或出现的数字以及索引加一，最后就是没出现的两个数字的异或值。
        把所有数字异或，得到一个数，
        这个数必定是两个只出现一次的数字异或得到的。
        异或规则是两个相应的bit位相同为0，不同为1。
        根据这个任意找一个为1的数位，根据这个数位为0和1分成两个数组，这样必定把两个结果数分开了，再分别异或就能得到结果。

 */
public class l_17 {
    public static void main(String[] args) {

    }

    public int[] missingTwo(int[] nums) {
        // 先得到异或的结果
        int n = nums.length;
        int bit = 0;
        for (int num : nums) {
            bit ^= num;
        }
        // 先通过1到n+2异或和nums数异或，获得了两个缺失数的异或
        for (int i = 1; i <= n + 2; i++) {
            bit ^= i;
        }

        // diff就是这个异或值的lowbit，
        // 代表着这两个缺失数在diff位上必有一个是0和一个是1。
        // 于是乎可以将1到n+2以及nums分为两组，
        // diff位置为0的为一组，diff位置为1的为一组。
        // 而缺失的两个数必然分别在不同的分组。所以题目就变成了寻找缺失的一个数组
        int diff = bit & -bit;

        // diff 就是这个异或值的lowbit
        int o = 0;
        // 这个是位置为0的一组
        for (int i = 1; i <= n; i++) {
            if ((diff & i) != 0) o ^= i;
        }
        for (int i : nums) {
            if ((diff & i) != 0) o ^= i;
        }
        return new int[]{o, o ^ bit};

    }

}
