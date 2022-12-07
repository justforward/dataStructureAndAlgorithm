package leetcode.offer.H回溯;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    排序之后，针对重复的元素进行剪纸操作
 */
public class offer_084 {
    List<List<Integer>> ans;
    boolean[] v;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        v = new boolean[nums.length];
        back(nums, new ArrayList<>());
        return ans;
    }


    public void back(int[] nums, ArrayList<Integer> tmp) {
        if (nums.length == tmp.size()) {
            ArrayList<Integer> res = new ArrayList<>();
            res.addAll(tmp);
            ans.add(res);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (v[i]) continue;
            // 固定相同的元素在排列组合中的相对位置
            //    // 如果前面的相邻相等元素没有用过，则跳过
            if (i > 0 && nums[i] == nums[i - 1] && !v[i - 1]) continue;
            v[i] = true;
            tmp.add(nums[i]);
            back(nums, tmp);
            v[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
