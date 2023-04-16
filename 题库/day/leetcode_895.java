package 题库.day;

import java.util.*;

public class leetcode_895 {


    class FreqStack {
        // 存储数字出现的频率
        HashMap<Integer, Integer> feqMap;
        // 优先队列，弹出离栈顶最近 出现频率最多次的数字
        PriorityQueue<int[]> queue;
        // 记录离栈顶最近的元素,针对出现频率一样的数字 查看
        int index;

        public FreqStack() {
            feqMap = new HashMap<>();
            queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // 频率相同的数字 查看谁离栈顶最近
                    if (o1[1] == o2[1]) {
                        return o2[2] - o1[2];
                    }
                    return o2[1] - o1[1];
                }
            });
        }

        public void push(int val) {
            // 存储数字的时候
            int cnt = feqMap.getOrDefault(val, 0) + 1;
            feqMap.put(val, cnt);
            queue.add(new int[]{val, cnt, index++});
        }

        public int pop() {
            int[] pull = queue.poll();
            feqMap.put(pull[0], pull[1] - 1);
            return pull[0];
        }
    }
}
