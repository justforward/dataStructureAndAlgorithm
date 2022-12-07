package leetcode.offer.H回溯;


import java.util.ArrayList;
import java.util.List;

/*
    得到全排列，全排列的需要进行记录已经选择的元素，如果当前遍历的已经选择这个元素
 */
public class offer_083 {
    List<List<Integer>> ans;
    boolean[] v;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        v = new boolean[nums.length];
        back(nums, new ArrayList<>());
        return ans;
    }


    public void back(int[] nums, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ArrayList<Integer> res = new ArrayList<>();
            res.addAll(tmp);
            ans.add(res);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            tmp.add(nums[i]);
            back(nums, tmp);
            v[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}
