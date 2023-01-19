package leetcode.offer.K不常见数据结构;

import java.util.*;

/*
    优先队列： 最小堆的和相减
 */
public class offer_061 {
    public static void main(String[] args) {
        offer_061 offer_061 = new offer_061();
        int[] nums1 = new int[]{1, 1, 2}, nums2 = new int[]{1, 2, 3};
        int k = 10;
        offer_061.kSmallestPairs(nums1, nums2, k);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            // 将num2的下标从0开始存放
            priorityQueue.add(new int[]{i, 0});
        }

        while (k-- > 0 && !priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
            // 这里统计的是数直接无法返回？需要统计下标可以
            if (++poll[1] < nums2.length) {
                priorityQueue.add(new int[]{poll[0], poll[1]});
            }
        }
        return ans;
    }
}
