package 题库.offer.M二分;

/**
 * @author tandi
 * @date 2023/1/31 下午9:39
 * <p>
 * <p>
 * 思路：
 * <p>
 * while的每一次执行都将使得right或left的位置相比当前center位置左移/右移一位，不难分析出无法进入while时的right和left的关系一定是right = left - 1。反推上一次能够进入while的情形：
 * <p>
 * 如果上一次进入while后是target < nums[center]，right被更新，right = center - 1，
 * 已知当前right = left - 1，说明当前left = center，
 * 由于target < nums[center]，插入位置是center（即left），
 * 也就是center（left）这个坐标的元素及其右边元素(直到i的左一位)，都要向右移动一位。
 * <p>
 * 如果上次进入while是target<nums[center] right 被更新，
 * <p>
 * 如果上一次进入while后是target ≥ nums[center]，left被更新，left = center + 1，已知当前right = left - 1，说明当前right = center，由于target ≥ nums[center]，插入位置是center+1（即left），也就是center+1（left）这个坐标的元素及其右边元素(直到i的左一位)，都要向右移动一位。
 * <p>
 * 以上结果均使得插入位置为当前的left (或当前的right + 1)。
 */
public class offer_068 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;// 更新后左侧的位置必然小于target
            else r = mid - 1;// 更新后右侧的位置必然大于等于target
        }
        return l;// l 作为第一个大于或者等于target的位置
    }

}
