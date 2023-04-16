package 题库.offer.O回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/2/25 下午6:18
 */
public class offer_85 {

//    List<String> ans = new ArrayList<>();
//
//    public List<String> generateParenthesis(int n) {
//        if (n == 0) {
//            return new ArrayList<>();
//        }
//        DFS(n, n, new StringBuilder());
//        return ans;
//    }
//
//    public void DFS(int l, int r, StringBuilder s) {
//        if (l == 0 && r == 0) {
//            ans.add(s.toString());
//            return;
//        }
//        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节
//        if (l > r) {
//            return;
//        }
//        if (l > 0) {
//            DFS(l - 1, r, s.append("("));
//        }
//        if (r > 0) {
//            DFS(l, r - 1, s.append(")"));
//        }
//    }


    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n);
        return res;
    }

    private void dfs(String curStr, int left, int right) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
        if (left == 0 && right == 0) {
            res.add(curStr.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1);
        }
    }
}
