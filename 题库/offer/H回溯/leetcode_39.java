package 题库.offer.H回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/3/17 下午9:10
 */
public class leetcode_39 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backed(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }

    public void backed(int[] candidates, int target, List<Integer> tmp, int sum, int startIndex) {

        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            sum += num;
            tmp.add(num);
            backed(candidates, target, tmp, sum, i);
            sum -= num;
            tmp.remove(tmp.size() - 1);
        }
    }

}
