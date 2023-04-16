package 题库.offer.H回溯;

import java.util.ArrayList;
import java.util.List;

public class offer_079 {
    public static void main(String[] args) {
        offer_079 offer_079 = new offer_079();
        int[] nums = new int[]{1, 2, 3};
        offer_079.subsets(nums);
        System.out.println(offer_079.ans);
    }

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        back(0, nums, new ArrayList<>());
        return ans;
    }

    public void back(int begin, int[] nums, ArrayList<Integer> tmp) {
        // 这里一定要进行数据的重写，否则会影响最后的结果？下次遍历的时候，会得到空值，出现覆盖的情况
        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(tmp);
        ans.add(res);
        for (int i = begin; i < nums.length; i++) {
            tmp.add(nums[i]);
            back(i + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
