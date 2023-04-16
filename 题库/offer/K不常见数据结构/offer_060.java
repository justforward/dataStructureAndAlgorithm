package 题库.offer.K不常见数据结构;

import java.util.*;

public class offer_060 {

    /*
      优先队列的定义
     */
    public static void main(String[] args) {
        offer_060 offer_060 = new offer_060();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        offer_060.topKFrequent(nums, k);
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        // 首先针对数字进行统计
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 小顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        // 统计得到的值
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (priorityQueue.size() == k) {
                // 查看顶部的值与当前值谁打
                if (priorityQueue.peek()[1] < value) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{key, value});
                }
            } else {
                priorityQueue.add(new int[]{key, value});
            }

        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }
}
