package leetcode.day;

import java.net.Inet4Address;
import java.util.*;

/*
    题意理解:必须从当前天 开始计算，不能跳过连续的
 */
public class StockSpanner {
    Stack<int[]> stack; // stack 存储的数据是数据+index
    int index;

    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price) {
        index++;
        // 查看price的数据
        //
        while (!stack.isEmpty() && stack.peek()[1] <= price) {
            stack.pop();
        }

        // 当前天数
        int ret = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return ret;

    }

    public static void main(String[] args) {
    }
}
