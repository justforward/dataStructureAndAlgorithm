package leetcode.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
    题目：
        给你一个整数 n ，请你找出并返回第 n 个 丑数 。
        丑数 就是只包含质因数 2、3 和 5 的正整数。

    题意：
        1）1是最小的丑数
        2）对于任意一个丑数x，与其任意质因数(2、3、5)相乘，得到的也是有个丑数

    思路：
        1）小跟堆
            1.1） 构建一个小跟堆（优先队列），首先将1添加
            1.2）然后取出小跟堆的顶节点，与因数(2\3\5)相乘，去重之后，再次放入到小跟堆
            1.3）遍历k次完毕，弹出堆顶元素
        2) 多路归并 双指针

 */
public class leetcode_264 {

    public int nthUglyNumber(int n) {
        int[] nums = new int[]{2, 3, 5};
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1l);

        // 防止出现 2*5 5*2的数据
        Set<Long> set = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            long p = priorityQueue.poll();
            if (--n == 0) return (int) p;
            for (int num : nums) {
                long tmp = num * p;
                if (!set.contains(tmp)) {
                    set.add(tmp);
                    priorityQueue.add(tmp);
                }
            }
        }
        return -1;
    }
}
