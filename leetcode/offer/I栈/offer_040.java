package leetcode.offer.I栈;


import java.util.Stack;

/*
    定义一个height[i]表示 当前层到最高层达到的连续的最大高度
 */
public class offer_040 {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int area = 0;
        int[] heights = new int[matrix[0].length()];
        for (String row : matrix) {
            for (int i = 0, length = heights.length; i < length; i++) {
                heights[i] = row.charAt(i) == '0' ? 0 : heights[i] + 1;
            }
            area = Math.max(area, largestRectangleArea(heights));
        }
        return area;
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
