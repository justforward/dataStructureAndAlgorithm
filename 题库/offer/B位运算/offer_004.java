package 题库.offer.B位运算;


/*
    只出现一次的数字

    思路:设计出来一个电路 让三次出现的数字 置为0
    开始设计：一个二进制位只能表示0或者1。也就是天生可以记录一个数出现了一次还是两次。

    1） hashMap

    2）位数统计

    对于出现三次的数字，二进制相同的位相加之后 得到的值肯定能被3整除 不能整除剩下的值就是只出现一次的值
    1）计算出 数字在32位上的每一个位 上是否是1 针对1的数字在32位数组上添加1
    2）对32上的每一位进行mod3操作 将其剩下的值转成十进制

    3）DFA
    设计出一个3次的异或
    目前 偶数出现的只需要进行一位进行
    x ^ 0 = x;
    x ^ x = 0;
    对于奇数出现的需要进行两位的异或


 */
public class offer_004 {
    public static void main(String[] args) {
        offer_004 offer_004 = new offer_004();
        int[] nums = new int[]{2, 2, 3, 2};
        offer_004.singleNumber(nums);
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                // 针对每一位进行得到值
                if (((num >> i) & 1) == 1) {
                    bits[i]++;
                }
            }
        }

        // 将每一位整除3
        for (int i = 0; i < 32; i++) {
            if (((bits[i] % 3) & 1) == 1) {
                ans += (bits[i] << i);
            }
        }
        return ans;
    }
}
