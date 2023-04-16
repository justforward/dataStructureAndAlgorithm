package 题库.offer.H回溯;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    排序之后，针对重复的元素进行剪纸操作
 */
public class offer_084 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        back(nums, new ArrayList<>());
        return ans;
    }

    public void back(int[] nums, ArrayList<Integer> tmp) {
        if (nums.length == tmp.size()) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            tmp.add(nums[i]);
            back(nums, tmp);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
