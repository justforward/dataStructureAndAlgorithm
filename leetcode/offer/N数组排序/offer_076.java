package leetcode.offer.N数组排序;

/**
 * @author tandi
 * @date 2023/2/21 下午10:42
 */
public class offer_076 {
    // 第k大的 也是第nums.length-k+1  小的
    public int findKthLargest(int[] nums, int k) {
        // 快排
        int n = nums.length;
        int m = n - k;//第K小为n-k+1  但是数组下标需要-1 操作 所以m才是第k小所在的数组下标
        quickSort(nums, 0, n - 1, m);
        return nums[m];

    }

    public int quickSort(int[] nums, int left, int right, int k) {
        while (left >= right) {
            return 0;
        }

        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= base) {
                j--;
            }
            while (i < j && nums[i] <= base) {
                i++;
            }

            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // 当前i所停下的位置一定是小于base的，所以需要将i的位置存放到left位置上
        nums[left] = nums[i];
        // 然后进行base数据放到应该存放的位置
        nums[i] = base;
        if (i == k) return nums[i];
        if (k < i)
            // 递归排序左边
            return quickSort(nums, left, i - 1, k);
            // 递归排序右边
        else
            return quickSort(nums, i + 1, right, k);
    }

}
