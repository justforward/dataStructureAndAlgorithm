package leetcode.offer;


/*
    只出现一次的数字

    思路:设计出来一个电路 让三次出现的数字 置为0
    开始设计：一个二进制位只能表示0或者1。也就是天生可以记录一个数出现了一次还是两次。

    1） hashMap

    2）位数统计

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
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                // 判断这个数字在当前位上是否为1
                if (((num >> i) & 1) == 1) {
                    bitSums[i]++;
                }
            }
        }

        // 根据得到
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((bitSums[i] % 3) & 1) == 1) {
                result += (1 << i);
            }
        }
        return result;

    }
}
