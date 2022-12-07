package leetcode.offer.H回溯;


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

    List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        // 遍历从 当前位置往后搜索
        //for (int i = 1; i <= n; i++) {
            ArrayList<Integer> array = new ArrayList<>();
            // 直接从1 开始，之后的数据
            back(n, k, array, 1);
        //}
        return ans;
    }

    public void back(int n, int k, List<Integer> tmpRes, int start) {
        if (tmpRes.size() == k) {
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(tmpRes);
            ans.add(tmp);
            return;
        }

        // 这个i的遍历是指 每次选择的开始节点
        // 每次选择
        for (int i = start; i <= n; i++) {
            tmpRes.add(i);
            back(n, k, tmpRes, i + 1);
            tmpRes.remove(tmpRes.size() - 1);
        }

    }

    public static void main(String[] args) {
        offer_080 offer_080 = new offer_080();
        offer_080.combine(4, 2);
        System.out.println(offer_080.ans);
    }
}
