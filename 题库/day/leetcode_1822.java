package 题库.day;

// 1、查看出现0
// 2、负数的个数
public class leetcode_1822 {
    public static void main(String[] args) {
        System.out.println(1024|2);
    }
    public int arraySign(int[] nums) {
        int minus = 0;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] < 0) {
                minus++;
            }
        }

        if (minus != 0 && minus % 2 != 0) {
            return -1;
        }
        return 1;

    }
}
