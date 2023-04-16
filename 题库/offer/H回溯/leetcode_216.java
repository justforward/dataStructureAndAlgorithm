package 题库.offer.H回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/3/17 下午8:53
 */
public class leetcode_216 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // k 作为树的深度，1到9作为树的宽度
        backed(k, n, 0, 1, new ArrayList<>());
        return ans;
    }
    public void backed(int k, int n, int sum, int begin, List<Integer> tmp) {
        if (tmp.size() == k) { // 在往下走就没有意义了。
            if (sum == n) ans.add(new ArrayList<>(tmp));
            return;
        }

        if(sum>n){ // 减枝的动作
            return;
        }

        for (int i = begin; i <= 9; i++) {
            sum += i;
            tmp.add(i);
            backed(k, n, sum, i + 1, tmp);
            sum -= i;
            tmp.remove(tmp.size() - 1);
        }
    }
}
