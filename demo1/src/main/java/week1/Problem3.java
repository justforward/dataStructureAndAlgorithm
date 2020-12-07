package week1;

import java.util.*;

/**
 * @author wangtan
 * @Date 2020/12/6
 * 贪心算法：区间问题
 * 435. Non-overlapping Intervals (Medium)
 * 题解：
 * 在选择要保留区间时，区间的结尾十分重要:
 * 选择的区间结尾越小，余留给其它区间的空间就越大，就越能保留更多的区间。
 * 因此，我们采取的贪心策略为，优先保留结尾小且不相交的区间。
 * 具体实现方法为:先把区间按照结尾的大小进行增序排序，
 * 每次选择结尾最小且和前一个选 择的区间不重叠的区间。
 */
public class Problem3 {
    public static void main(String[] args) {
        // int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        if (intervals.length == 1 || intervals.length == 0) {
            return result;
        }
        //二维数组排序列（行之间有序），按照列的第几个元素排序。目前题目给定的是 两列多行的数
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
                //return o1[0]-o2[0]; 按照第一列的元素排序
            }
        });
        //第一层循环的是当前的数值
        //执行排序得到的数列；[1,11] [2,12] [11,22] [1,100]
        //每次只需要跟最新的前一个对比即可
        //初始状态
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                result++;
            } else {
                prev = intervals[i][1];
            }
        }
        return result;
    }


}
