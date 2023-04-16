package 题库.niuke.B二分查找排序;

/**
 * @author tandi
 * @date 2023/3/18 下午8:37
 */
public class BM20 {
    public int InversePairs(int[] array) {
        //逆序对：如果前面的值大于后面的值
        return (int) (merge(array, 0, array.length - 1) % 1000000007);

    }


    public long merge(int[] nums, int l, int r) {
        // 得到的是逆序对的个数
        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        long left = merge(nums, l, mid);
        long right = merge(nums, mid + 1, r);
        // 需要构建一个临时数组
        int[] tmp = new int[l - r + 1];
        int index = 0;
        int res = 0;
        int i = l;
        int j = mid + 1;

        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[index++] = nums[i++];
            } else {
                tmp[index++] = nums[j++];
                // 从i到mid相对于j来说都是逆序对
                res += mid - i + 1;
            }
        }

        while (i <= mid) {
            tmp[index++] = nums[i++];
        }
        while (j <= r) {
            tmp[index++] = nums[j++];
        }
        for (int m = 0; m < tmp.length; m++) {
            nums[m + l] = tmp[m];
        }
        return res + left + right;

    }
}
