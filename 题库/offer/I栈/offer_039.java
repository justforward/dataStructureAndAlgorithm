package 题库.offer.I栈;

import java.util.Stack;

// [2,5,4,6,4,3]
//  stack 里面存储的是数组的下标，遇到需要弹出的数据，需要将这个下标进行弹出
public class offer_039 {

    public static void main(String[] args) {
        int[] heights = new int[]{2, 5, 4, 6, 4, 3};
        offer_039 offer_039 = new offer_039();
        int i = offer_039.largestRectangleArea(heights);
        System.out.println(i);
    }

    public int largestRectangleArea(int[] heights) {
        int ans = Integer.MIN_VALUE;
        // 找到矩阵面积的最大值
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                ans = Math.max(ans, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.add(i);
        }

        // 到了最后，如果stack中还有剩余
        while (stack.peek() != -1) {
            ans = Math.max(ans, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return ans;
    }
}
