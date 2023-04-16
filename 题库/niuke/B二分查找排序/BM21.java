package 题库.niuke.B二分查找排序;

/**
 * @author tandi
 * @date 2023/3/18 下午9:04
 */
public class BM21 {
    public int minNumberInRotateArray(int[] array) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //mid的左边一定是排序的
            if (array[mid] > array[r]) {
                l = mid + 1;
            } else if (array[mid] < array[r]) {
                // mid的右边一定是排序的
                r = mid;
            } else {
                r--; // 无法判断 缩小右边界产生
            }
        }
        return array[l];
    }
}
