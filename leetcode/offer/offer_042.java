package leetcode.offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/*
    保证 每次对 ping 的调用都使用比之前更大的 t 值。

    由于每次收到的调用都比之前的数字要大，因此队首到队尾的时间值是单调递增。为了求【t-3000,t】
    我们不断弹出队首小于【t-3000】的数字，剩下的队列中的数字个数就是我们需要的值。

 */
public class offer_042 {

    class RecentCounter {

        Queue<Integer> queue;

        public RecentCounter() {
            queue=new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while(queue.peek()<t-3000){
                queue.poll();
            }

            return queue.size();
        }
    }
}
