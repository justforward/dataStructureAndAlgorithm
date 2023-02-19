package leetcode.offer.M二分;

/**
 * @author tandi
 * @date 2023/2/16 下午9:53
 */
public class leetcode_34 {

    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];
        ans[0] = left_bound(nums, target);
        ans[1] = right_bound(nums, target);
        return ans;
    }


    public int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                left = mid + 1; // 往
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }
}
