package leetcode.offer;

import java.util.Stack;

public class offer_036 {

    // 使用栈进行计算 遇到计算符号 弹出数字

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // 不是整数
            if (Character.isDigit(token.charAt(0))) {

            }
        }

        return 0;

    }
}
