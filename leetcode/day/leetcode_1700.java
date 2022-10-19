package leetcode.day;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode_1700 {
    public static void main(String[] args) {
        int[] students = new int[]{1, 1, 1, 0, 0, 1};
        int[] sandwiches = new int[]{1, 0, 0, 0, 1, 1};
        leetcode_1700 leetcode_1700 = new leetcode_1700();
        System.out.println(leetcode_1700.countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            stack.add(sandwiches[i]);
        }

        for (int j = 0; j < students.length; j++) {
            queue.add(students[j]);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == queue.peek()) {
                stack.pop();
                queue.poll();
            } else {
                queue.add(queue.poll());
                if (!queue.contains(stack.peek())) {
                    break;
                }
            }
        }

        return stack.size();

    }

}