package leetcode.offer.O回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tandi
 * @date 2023/2/25 下午5:40
 */
public class offer_79 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            // 设定子集的size
            DFS(nums, 0, i, new ArrayList<>());
        }
        return ans;
    }

    public void DFS(int[] nums, int begin, int size, List<Integer> tmp) {
        if (tmp.size() == size) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            tmp.add(nums[i]);
            DFS(nums, begin + 1, size, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

//    List<List<Integer>> subsets = new ArrayList<>();
//
//    public List<List<Integer>> subsets(int[] nums) {
//        //List<Integer> tempSubset = ;
//        for (int size = 0; size <= nums.length; size++) {
//            backtracking(0, new ArrayList<>(), size, nums);
//        }
//        return subsets;
//    }
//
//    private void backtracking(int start, List<Integer> tempSubset, int size, int[] nums) {
//
//        if (tempSubset.size() == size) {
//            subsets.add(new ArrayList<>(tempSubset));
//            return;
//        }
//        for (int i = start; i < nums.length; i++) {
//            tempSubset.add(nums[i]);
//            backtracking(i + 1, tempSubset, size, nums);
//            tempSubset.remove(tempSubset.size() - 1);
//        }
//    }


}
