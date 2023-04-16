package 题库.math;

/*
    题目：
        有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
        注意，不是必须有这些素因子，
        而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

    思路：多路归并 |堆 | 优先队列
         1) 小跟堆
            1.1）构建一个小根堆，首先将1进行入队列操作
            1.2）每次最小的值进行入队列操作，每次取出最小的值进行素因子的相乘操作。
            1.2）一共操作k次，那么最后一次的小跟堆位置上的元素就是需要的值

         2）多路归并——（多指针）
         `
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class interview_17_09 {
    public static void main(String[] args) {
        int k = 5;
        interview_17_09 i = new interview_17_09();
        System.out.println(i.getKthMagicNumber(k));

    }

    public int getKthMagicNumber(int k) {
        int[] nums = new int[]{3, 5, 7};
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        // 记录重复进入的数字,进行去重的操作
        Set<Long> set = new HashSet<>();
        priorityQueue.add(1l);
        while (!priorityQueue.isEmpty()) {
            // 每次遍历的值是k--的操作
            long t = priorityQueue.poll();
            if (--k == 0) return (int) t;
            for (int num : nums) {
                if (!set.contains(num * t)) {
                    set.add(num * t);
                    priorityQueue.add(num * t);
                }
            }
        }
        return -1;
    }

    public int getKthMagicNumber1(int k) {
        // 第k个最大数
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        //
        // 数据的范围多大？进行遍历计算？
        int Max_Integer = Integer.MAX_VALUE;
        for (int i = 1; i < Max_Integer; i++) {
            if (isValid(i) && heap.size() < k) {
                heap.add(i);
            }
            if (heap.size() == k) {
                break;
            }
        }
        return heap.peek();
    }

    public boolean isValid(int n) {
        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else if (n % 7 == 0) {
                n /= 7;
            } else {
                return false;
            }
        }
        return true;
    }
}
