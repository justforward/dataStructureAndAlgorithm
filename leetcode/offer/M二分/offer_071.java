package leetcode.offer.M二分;

import java.util.Arrays;
import java.util.Random;

/**
 * @author tandi
 * @date 2023/2/8 下午9:20
 * 操作系统中的彩票调度算法（比例份额（proportional-share）调度程序）
 * https://www.cnblogs.com/shuo-ouyang/p/12747980.html
 * <p>
 * 按照权重生成随机数
 */
public class offer_071 {

    /*
       彩票调度算法
     */
    static class Solution {

        private int[] w;
        private int size = 0; // 记录总和
        private static final Random ran = new Random();// 从总和中抽取一个值，

        public Solution(int[] w) {
            this.w = w;
            for (int n : w) {
                size += n;
            }
        }

        public int pickIndex() {
            int r = ran.nextInt(size);
            int sum = 0;
            for (int i = 0; i < size; i++) {
                if ((sum += w[i]) > r) {
                    return i;
                }
            }
            return 0;
        }
    }

    // 前缀和+二分查找
    // 为什么要选取前缀和？ 利用二分查找快速找到小于某个前缀和的数组下标
    static class Solution1 {
        int[] pre;
        int total;
        private static final Random ran = new Random();// 从总和中抽取一个值，

        public Solution1(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            // 得到前缀和数组
            for (int i = 1; i < w.length; ++i) {
                pre[i] = pre[i - 1] + w[i];
            }
            // 快速计算sum的函数
            total = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            // random 的范围是[1,last]
            int i = ran.nextInt(total) + 1; //生成的随机数从1到total 把[0, last)提升到[1, last] ？为什么要提升？
            return binarySearch(i);
        }

        // 寻找首个大于x的位置
        public int binarySearch(int x) {
            int left = 0, right = pre.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (pre[mid] < x) left = mid + 1; // 直接跳过mid
                else right = mid - 1; // 针对满足条件的，别返回 继续缩小空间去找边界 查看labulado的小炒
            }
            // 找到首个大于x的位置
            return left;
        }


        public int right_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 这里改成收缩左侧边界即可
                    left = mid + 1;
                }
            }
            // 最后改成返回 left - 1 由于终止条件是[right,right+1] right=left-1 此时
            if (right < 0) {
                return -1;
            }
            return nums[right] == target ? right : -1;
        }
    }


}
