package leetcode.bit.leetcode_bank;

import java.util.HashMap;
import java.util.Map;

/*
    题目：
        集合 s 包含从 1 到 n 的整数。
        不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
        导致集合 丢失了一个数字 并且 有一个数字重复 。 先找这个重复的值，然后再找到这个丢失的值

    思路：
    1）位远算：加上索引之后，缺失的值出现的次数是1 、重复的值出现的次数是3
                位运算+hash
    2) 位运算：异或加lowbit操作
 */
public class leetcode_645 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4};
        leetcode_645 l = new leetcode_645();
        int[] errorNums = l.findErrorNums(nums);
        System.out.println(errorNums[0]);
        System.out.println(errorNums[1]);
    }

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                res[0] = num;
                break;
            } else {
                hashMap.put(num, 1);
            }
        }

        // 异或操作，对于重复值只计算一次
        int bit = 0;
        for (int num : nums) {
            if (num != res[0]) {
                bit ^= num;
            }
        }

        bit ^= res[0];
        for (int i = 1; i <= nums.length; i++) {
            bit ^= i;
        }

        res[1] = bit;
        return res;
    }

    // 根据lowbit算法进行区分两个值
    public int[] findErrorNums_two(int[] nums) {
        int bit = 0;
        for (int num : nums) bit ^= num;
        for (int i = 1; i <= nums.length; i++) bit ^= i;

        int diff = bit & (-bit);

        int type1 = 0, type2 = 0;
        // 根据diff的结果进行区分nums
        for (int num : nums) {
            if ((diff & num) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((diff & i) != 0) {
                type1 ^= i;
            } else {
                type2 ^= i;
            }
        }

        // 先找到这个重复的值
        for (int num : nums) {
            if (type1 == num) {
                return new int[]{type1, type2};
            }
        }

        return new int[]{type2, type1};
    }

}