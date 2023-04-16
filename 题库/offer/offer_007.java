package 题库.offer;

import java.util.*;

public class offer_007 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == 0) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left++]);
                    res.add(nums[right--]);
                    set.add(res);
                } else if (tmp > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        ans.addAll(set);
        return ans;
    }
}
