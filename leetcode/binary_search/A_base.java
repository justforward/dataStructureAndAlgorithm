package leetcode.binary_search;

import java.util.Arrays;

public class A_base {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5, 6, 7};
        int i = Arrays.binarySearch(nums, 0, nums.length, 3);
        System.out.println(i);
    }

    // 找到一个目标值
    public int SearchOne(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // left和right 可能会相等的时候
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int SearchLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        // 可能会出现目标一直大于nums中所有的值
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    public int SearchRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


}
