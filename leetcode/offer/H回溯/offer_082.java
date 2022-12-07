package leetcode.offer.H回溯;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    含有重复元素集合的组合
 */
public class offer_082 {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        back(0, target, candidates, 0, new ArrayList<>());
        return ans;
    }


    public void back(int begin, int target, int[] nums, int sum, ArrayList<Integer> tmp) {
        if (target == sum) {
            ArrayList<Integer> res = new ArrayList<>();
            res.addAll(tmp);
            ans.add(res);
            return;
        } else if (target < sum) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            // 值相同的树枝，只遍历第一个？
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            int cur = nums[i];
            tmp.add(cur);
            back(i + 1, target, nums, sum += cur, tmp);
            sum -= cur;
            tmp.remove(tmp.size() - 1);
        }
    }
}
