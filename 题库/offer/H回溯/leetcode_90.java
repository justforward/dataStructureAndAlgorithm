package 题库.offer.H回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tandi
 * @date 2023/3/17 下午11:00
 */
public class leetcode_90 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        back(nums, 0, new ArrayList<>());
        return result;
    }

    private void back(int[] nums, int startIndex, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            back(nums, i + 1, temp);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
