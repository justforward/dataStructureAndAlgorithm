package leetcode.niuke.A链表和栈;

import java.util.Stack;

/**
 * @author tandi
 * @date 2023/3/12 下午8:12
 */
public class t_42 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        // 先入后出
        stack1.add(node);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
