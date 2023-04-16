package 题库.offer.K不常见数据结构;

import java.util.PriorityQueue;

public class offer_059 {

    // 找到数据流中的最大值
    class KthLargest {
        // 头节点是最小值
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            for (int num : nums) {
                queue.add(num);
            }
            while (queue.size() > k) {
                queue.poll();
            }
            this.k = k;
        }

        public int add(int val) {
            queue.add(val);
            while (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
