package 题库.stack;


import java.util.Deque;
import java.util.LinkedList;

/*
    题目：
        1）嵌套括号，得分要乘二
        2）如果是并列，得分相加
    思路：栈
          如何判断是嵌套括号？还是并列括号？
                如果 ) 前面是 (, 即 (), 并列的
                如果 ) 前面还是 ), 即 ...)), 嵌套的

 */
public class leetcode_856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> deque = new LinkedList<>();
        char pre = ')';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 得到当前的值
            if (c == '(') {
                deque.add(0);
            } else {
                Integer curValue = deque.pollLast();
                if (pre == '(') {
                    curValue++;
                } else {
                    curValue *= 2;
                }
                if (deque.isEmpty()) res += curValue;
                else {
                    int tmp = deque.pollLast() + curValue;
                    deque.addLast(tmp);
                }
            }
            pre = c;
        }

        return res;
    }
}
