package 题库.offer.H回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tandi
 * @date 2023/3/17 下午9:50
 */
public class leetcode_40 {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 首先将数组排序
        Arrays.sort(candidates);
        back(candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }
    public void back(int[] nums, int target, int sum, List<Integer> tmp, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // 说明前一个相同的数字在本次没有被使用，那么在同一个层的前一个肯定被使用，就会出现
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            int num = nums[i];
            sum += num;
            tmp.add(num);
            back(nums, target, sum, tmp, i + 1);
            used[i] = false;
            sum -= nums[i];
            tmp.remove(tmp.size() - 1);
        }

    }


}
