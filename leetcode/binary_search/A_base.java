package leetcode.binary_search;

import java.util.Arrays;

public class A_base {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5, 6, 7};
//        int i = Arrays.binarySearch(nums, 0, nums.length, 3);
//        System.out.println(i);
        A_base a_base = new A_base();
        a_base.find_right(nums, 3);
    }

    public int find_right(int[] nums, int target) {
        // 二分找到
        int m = nums.length;
        int l = 0, r = m - 1;
        // l<r 的时候
        // 二分法找到 右边界的值
//        while (l < r) {
//            int mid = l + r + 1 >> 1;
//            if (nums[mid] <= target) l = mid;
//            else r = mid - 1;
//        }

        // 二分法 找到左边界的值
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
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
