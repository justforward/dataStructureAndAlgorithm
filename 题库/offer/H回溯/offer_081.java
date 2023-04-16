package 题库.offer.H回溯;


import java.util.ArrayList;
import java.util.List;


/*
    给定一个数组，和对应的target值，求能得到这个target值的数据组合，
    这个组合里面的值是可以重复的

 */
public class offer_081 {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        back(0, candidates, target, 0, new ArrayList<>());
        return ans;
    }

    public void back(int begin, int[] nums, int target, int sum, ArrayList<Integer> tmp) {
        if (sum == target) {
            ArrayList<Integer> res = new ArrayList<>();
            res.addAll(tmp);
            ans.add(res);
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            int cur = nums[i];
            tmp.add(cur);
            // 可以重复选这个值
            // 遍历到下一层
            back(i, nums, target, sum += cur, tmp);
            sum -= cur;
            tmp.remove(tmp.size() - 1);
        }
    }


}
