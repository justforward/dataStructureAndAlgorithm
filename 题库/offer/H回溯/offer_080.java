package 题库.offer.H回溯;


import java.util.ArrayList;
import java.util.List;


/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
示例 1:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

public class offer_080 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 直接从1 开始，之后的数据
        back(n, k, new ArrayList<>(), 1);
        return ans;
    }

    public void back(int n, int k, List<Integer> tmpRes, int start) {
        if (tmpRes.size() == k) {
            ans.add(new ArrayList<>(tmpRes));
            return;
        }

        for (int i = start; i <= n; i++) {
            tmpRes.add(i);
            back(n, k, tmpRes, i + 1);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }

}
