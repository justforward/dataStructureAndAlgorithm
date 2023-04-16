package 题库.top100;

import java.util.Stack;

/**
 * @author tandi
 * @date 2023/3/12 下午9:27
 */
public class leetcode_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty(); // 如果为空 说明没有匹配完
    }
}
