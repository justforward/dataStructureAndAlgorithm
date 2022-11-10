package leetcode.offer;

import java.util.Arrays;

// 双指针 + 二分查找？
public class offer_006 {
    public static void main(String[] args) {
        offer_006 offer_006 = new offer_006();
        int[] numbers = new int[]{-3, 3, 4, 90};
        int target = 0;
        int[] ints = offer_006.twoSum(numbers, target);
        System.out.println(ints[0] + " " + ints[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        // 双指针
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp < target) {
                left++;
            } else if (tmp > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }


}
