package leetcode.math;

import java.util.PriorityQueue;

/*
    题目：
        那么第k个最小的分数是多少呢?
    题量：
        范围是 Integer.MAX_VALUE~10^9
        10^5 O(n^2)=10^10   已经超过？
        10^6 O(n^2)=10^12   确定已经超过。。。

    本题数据范围：
        1 <= arr[i] <= 3 * 10^4 可以使用O(n^2)的复杂度

    思路：
        1）以此扫描+小根堆
        2）数组内元素严格单调递增
            根据nums[j]为分母，得到的是严格递增的。
            维护多个有序队列的当前头部的最小值。根据头部的元素进行构建

 */
public class leetcode_786 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5};
        leetcode_786 l = new leetcode_786();
        int[] num = l.kthSmallestPrimeFraction(nums, 3);
        System.out.println(num[0] + " " + num[1]);
    }

    /*
        两个int数相除保留小数点，
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        // 求解第k个最小的分数
        // 默认是小根堆，以条件构建出来大跟堆
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[0] * 1.0 / b[1], a[0] * 1.0 / a[1]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double t = arr[i] * 1.0 / arr[j];
                if (q.size() < k || q.peek()[0] * 1.0 / q.peek()[1] > t) {
                    if (q.size() == k) q.poll();
                    q.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return q.poll();
    }
}
