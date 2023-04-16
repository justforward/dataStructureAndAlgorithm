package 题库.offer.M二分;

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

    // 模版一「一般」情形3: 小于等于
    public int left_bound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int c = l + (r - l) / 2;
            if (nums[c] > target) r = c - 1; // r右边的值必然大于target
            else l = c + 1; // #2 l 左边的值必然小于等target
        }
        // return (r == -1 || nums[r] != target) ? -1 : r; // 704题的返回，处理:相等/不等
        return r; // 处理: 相等/刚好小于/不存在
    }


    public int right_bound(int[] nums, int traget) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < traget) left = mid + 1;
            else right = mid - 1;// right右边的值必然大于等于traget
        }
        return 0;
    }


    // 找到第一个大于等于
//    public int left_bound(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        int ans = -1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] > target) {
//                left = mid + 1; // 往
//            } else {
//                ans = mid;
//                right = mid - 1;
//            }
//        }
//        return ans;
//    }
//
//    public int right_bound(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        int ans = -1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] > target) {
//                right = mid - 1;
//            } else {
//                ans = mid;
//                left = mid + 1;
//            }
//        }
//        return ans;
//    }
}
