package leetcode.design;


import javax.management.Query;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
    题目：
        请定义一个队列并实现函数 max_value 得到队列里的最大值，
        要求函数max_value、push_back 和 pop_front
        的均摊时间复杂度都是O(1)。

        1) 还是满足队列先进出去的
        2）需要一个双端队列来维护max_value


    思路：
        1）需要维持队列的单调递减。

        从队列尾部插入元素时，我们可以提前取出队列中所有比这个元素小的元素，使得队列中只保留对结果有影响的数字。
        这样的方法等价于要求维持队列单调递减，即要保证每个元素的前面都没有比它小的元素。

        维持队列的单调递减
        在队列尾部插入元素时候，我们可以提前取出队列中所有比这个元素小的元素，队列中只保留对姐夫哦有


 */
public class interview_59 {

    class MaxQueue {
        Queue<Integer> q;
        // 双端队列  队列的两个端口 都可以进行元素的crud操作
        // 维护元素的单调递增
        Deque<Integer> d;

        public MaxQueue() {
            this.q = new LinkedList<>();
            this.d = new LinkedList<>();
        }

        public int max_value() {
            // 得到队列中的最大值
            if (d.isEmpty()) {
                return -1;
            }
            // 取出最开始进入队列的元素
            return d.peekFirst();
        }

        // 存入一个元素
        public void push_back(int value) {
            // 如果这个单调队列不为空，那么需要对比单调队列中的头部元素和当前需要插入元素的大小
            while (!d.isEmpty() && d.peekLast() < value) {
                // 将之后的进行弹出
                d.pollLast();
            }
            d.offerLast(value);
            q.offer(value);
        }

        //先进先出
        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }

            // 取出队列中的元素
            int ans = q.poll();
            // 如果这个元素等于d的最顶部的元素，那么d里面需要将这个元素进行弹出
            if (ans == d.peekFirst()) {
                d.pollFirst();
            }
            return ans;
        }
    }
}
