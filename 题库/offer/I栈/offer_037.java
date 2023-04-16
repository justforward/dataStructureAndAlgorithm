package 题库.offer.I栈;

import java.util.Stack;

/*
知识点：栈的简单模拟

思路：
    当小行星存在并且aster<0,并且栈顶元素非空并且小于0的时候，说明两个小行星相互向对方进行移动
    如果栈顶元素大于等于-aster,则小行星会发生爆炸，将alive置为false
    如果栈顶元素小于等于-aster,则栈顶元素表示的小行星会发生爆炸，执行出栈操作。
    重复上面的条件，直到不满足，如果最后小行星还存在，则将小行星入栈
 */
public class offer_037 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int cur = asteroids[i];
            boolean alive = true;
            while (alive && !stack.isEmpty() && cur < 0 && stack.peek() > 0) {
                // 目前的元素为异号
                alive = stack.peek() < -cur;
                if (stack.peek() <= -cur) {
                    stack.pop();
                }
            }

            // 如果当前的元素还存在的情况下，直接进行入栈操作
            if (alive) {
                stack.add(cur);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = stack.size(); i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
