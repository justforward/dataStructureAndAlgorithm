package leetcode.offer.M二分;

/**
 * @author tandi
 * @date 2023/2/13 下午9:11
 */
public class offer_072 {

    // 找到右边界小于等于x/2的值
    public int mySqrt(int x) {
        if (x == 1) return 1;
        // 二分查找，根据x 得到
        // 为什么right 取中值，因为开方之后不可能大于中间的值
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        // 锁定右边的区间
        return right;
    }

}
