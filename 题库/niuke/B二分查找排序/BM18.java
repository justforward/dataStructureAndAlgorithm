package 题库.niuke.B二分查找排序;

/**
 * @author tandi
 * @date 2023/3/18 下午8:29
 */
public class BM18 {
    public boolean Find(int target, int[][] array) {

        // 从右上角开始查找
        int i = array.length - 1;
        int j = 0;

        while (i >= 0 && j < array[0].length) {
            if (array[i][j] > target) {
                i--;
            } else if (array[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
