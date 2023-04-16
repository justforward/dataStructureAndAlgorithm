package 题库.offer.H回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/3/17 下午10:50
 */
public class leetcode_79 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        back(nums, 0, new ArrayList<>());
        return ans;
    }

    public void back(int[] nums, int index, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        if (index >= nums.length) return;

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            temp.add(num);
            back(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
