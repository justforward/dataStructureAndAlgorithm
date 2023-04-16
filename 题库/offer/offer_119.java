package 题库.offer;

import java.util.Arrays;
import java.util.HashSet;

/*
    最长连续数字，指的是（1，2，3，4，5，6，7，8...）的数字

    判断连续的数字？nums[right]-nums[left]==1
 */
public class offer_119 {
    public static void main(String[] args) {
        offer_119 offer = new offer_119();
        int[] nums = new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3};
        System.out.println(offer.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (nums.length <= 1) {
            return len;
        }
        // 数字排序 之后找到连续的值
        // 去重 之后排序
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int[] tmpNum = new int[set.size()];
        int index = 0;
        for (int n : set) {
            tmpNum[index++] = n;
        }
        //排序
        Arrays.sort(tmpNum);

        // 寻找递增的值
        int right = 1;
        int ans = 0;

        // 指向的值 就是当前的第一个值
        int tmpRes = 1;
        while (right < tmpNum.length) {
            // 根据得到的right left
            if (tmpNum[right] - tmpNum[right - 1] == 1) {
                tmpRes++;
            } else {
                // 当前left指向的那个数字
                ans = Math.max(ans, tmpRes);
                tmpRes = 1;
            }
            right++;
        }

        return Math.max(ans, tmpRes);
    }
}
