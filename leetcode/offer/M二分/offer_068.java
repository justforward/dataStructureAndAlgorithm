package leetcode.offer.M二分;

/**
 * @author tandi
 * @date 2023/1/31 下午9:39
 *
 *
 * 思路：
 *
 * while的每一次执行都将使得right或left的位置相比当前center位置左移/右移一位，不难分析出无法进入while时的right和left的关系一定是right = left - 1。反推上一次能够进入while的情形：
 *
 * 如果上一次进入while后是target < nums[center]，right被更新，right = center - 1，已知当前right = left - 1，说明当前left = center，由于target < nums[center]，插入位置是center（即left），也就是center（left）这个坐标的元素及其右边元素(直到i的左一位)，都要向右移动一位。
 *
 * 如果上一次进入while后是target ≥ nums[center]，left被更新，left = center + 1，已知当前right = left - 1，说明当前right = center，由于target ≥ nums[center]，插入位置是center+1（即left），也就是center+1（left）这个坐标的元素及其右边元素(直到i的左一位)，都要向右移动一位。
 *
 * 以上结果均使得插入位置为当前的left (或当前的right + 1)。
 */
public class offer_068 {

    // nums 为无重复元素的升序排列数组
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) { // left==right+1 的是区间停止
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) { // 因为mid已经对比过
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
