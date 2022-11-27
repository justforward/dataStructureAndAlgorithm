package leetcode.sort;

import java.util.Arrays;

public class base {
    public static void main(String[] args) {
        int[] arr = new int[] {9,4,6,8,3,10,10,6,9};
        sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 基数从数组的最左边的一个元素
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= base) {
                j--;
            }
            while (i < j && nums[i] <= base) {
                i++;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // 当前i所停下的位置一定是小于base的，所以需要将i的位置存放到left位置上
        nums[left] = nums[i];
        // 然后进行base数据放到应该存放的位置
        nums[i] = base;
        // 递归排序左边
        sort(nums, left, i - 1);
        // 递归排序右边
        sort(nums, i + 1, right);


    }

}
