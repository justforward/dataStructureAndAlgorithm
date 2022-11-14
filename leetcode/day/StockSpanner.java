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

    public String customSortString(String order, String s) {
        // 统计s的词频  根据order进行判断
        int[] value = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            value[index]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            int cur = order.charAt(i) - 'a';
            while (value[cur] > 0) {
                stringBuilder.append(order.charAt(i));
                value[cur]--;
            }
        }

        // 直接遍历剩下的单词
        for (int i = 0; i < 26; i++) {
            while (value[i] > 0) {
                stringBuilder.append((char) (i + 'a'));
                value[i]--;
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.customSortString(order, s));
    }
}
