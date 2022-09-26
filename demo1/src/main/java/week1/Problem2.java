package demo1.src.main.java.week1;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @author wangtan
 * @Date 2020/12/6
 * 贪心算法：分配问题
 * leetcode：135. Candy (Hard)
 * 题解：
 * 存在比较关系的贪心策略一定需要排序或是选择?
 * 但我们只需要简单的两次遍历即可:
 * 1）把所有孩子的糖果数初始化为 1;
 * 2）从左往右遍历一遍：
 * 如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的糖果数加 1;
 * 3）从右往左遍历一遍：
 * 如果左边孩子的评分比右边的高，且左边孩子当前的糖果数 不大于右边孩子的糖果数，
 * 则左边孩子的糖果数更新为右边孩子的糖果数加 1。
 * 通过这两次遍历，分配的糖果就可以满足题目要求了。
 * 这里的贪心策略即为，在每次遍历中，只考虑并更新相邻一侧的大小关系。
 */
public class Problem2 {
    public static void main(String[] args) {
        int[] rat={1,2,87,87,87,2,1};
        System.out.println(candy(rat));
    }
    public static int candy(int[] ratings) {
        int result = 0;
        //先给每个孩子分发一个糖果
        //这个数组是给孩子分发的糖果分布
        int[] candy = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candy[i] = 1;
        }
        //从左到右的第一次扫描
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i-1] + 1;
            }
        }
        //从右到左
        for (int i = ratings.length - 1; i != 0; i--) {
            if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
                candy[i - 1] = candy[i] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            result = result + candy[i];
        }
        return result;
    }
}
