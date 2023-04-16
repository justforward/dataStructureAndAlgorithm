package 题库.day;

import java.util.Stack;

/*
    解析表达式？栈
    1）字符串入栈
    2）根据入栈的顺序 期望值
 */
public class leetcode_1678 {
    public static void main(String[] args) {
        leetcode_1678 leetcode_1678 = new leetcode_1678();
        String command = "G()(al)";
        System.out.println(leetcode_1678.interpret(command));
    }

    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < command.length(); i++) {
            stack.add(command.charAt(i));
        }

        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            if (pop == 'G') {
                ans.append(pop);
            } else if (pop == ')') {
                if (stack.peek() == '(') {
                    ans.append('o');
                } else {
                    for (int i = 0; i < 2; i++) {
                        ans.append(stack.pop());
                    }
                }
                stack.pop();
            }
        }
        return ans.reverse().toString();
    }
}
