package day_train.simulate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class offer_2_41 {

    class MovingAverage {

        int size;
        Queue<Integer> queue;
        int sum;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.sum = 0;
            this.size = size;
            this.queue = new LinkedList<>();
        }

        public double next(int val) {
            sum += val;
            queue.add(val);
            while (queue.size() > size) {
                Integer poll = queue.poll();
                sum -= poll;
            }

            return sum / size;
        }


    }
}
