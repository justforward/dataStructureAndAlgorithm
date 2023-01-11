package leetcode.weekend;

public class train_xxx {
    public static void main(String[] args) {
        train_xxx train_xxx = new train_xxx();
        int[] nums = new int[]{-2, -1, -1, 1, 2, 3};
        System.out.println(train_xxx.maximumCount(nums));
    }

    public int maximumCount(int[] nums) {
        // 二分查找？
        return search(nums);
    }

    public int search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
