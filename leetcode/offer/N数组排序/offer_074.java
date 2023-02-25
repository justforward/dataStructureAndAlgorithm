package leetcode.offer.N数组排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tandi
 * @date 2023/2/21 下午9:38
 */
public class offer_074 {
    public int[][] merge(int[][] intervals) {
        // 根据数组中第一个元素进行排序
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        List<int[]> ans = new ArrayList<>();

        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                // 合并区间 更新区间
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                // 否则不需要合并区间
                ans.add(cur);
                cur = intervals[i];
            }
        }

        // 把最后一个加入到结果中
        ans.add(cur);
        return ans.toArray(new int[ans.size()][2]);
    }
}