package 题库.day;

import java.util.*;

public class leetcode_2023 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 1}, nums2 = new int[]{2, 3}, nums3 = new int[]{1, 2};
        leetcode_2023 leetcode_2023 = new leetcode_2023();
        leetcode_2023.twoOutOfThree1(nums1, nums2, nums3);
    }

    // 使用桶统计频次 去重的概念
    // 使用数组下标记录数字，数组的值记录出现次数
    public List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new LinkedList<>();

        int[] nums1_bucket = new int[101];
        int[] nums2_bucket = new int[101];
        int[] nums3_bucket = new int[101];

        for (int i = 0; i < nums1.length; i++) {
            if (nums1_bucket[nums1[i]] == 0) {
                nums1_bucket[nums1[i]] = 1;
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (nums2_bucket[nums2[j]] == 0) {
                nums2_bucket[nums2[j]] = 1;
            }
        }

        for (int k = 0; k < nums3.length; k++) {
            if (nums3_bucket[nums3[k]] == 0) {
                nums3_bucket[nums3[k]] = 1;
            }
        }

        for (int m = 0; m < 101; m++) {
            if (nums1_bucket[m] + nums2_bucket[m] + nums3_bucket[m] >= 2) {
                ans.add(m);
            }
        }
        return ans;
    }


    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new LinkedList<>();
        Set<Integer> tmp = new HashSet<>();
        Map<Integer, Integer> nums1_map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1_map.put(nums1[i], nums1_map.getOrDefault(nums1[i], 0) + 1);
        }

        Map<Integer, Integer> nums2_map = new HashMap<>();
        for (int j = 0; j < nums2.length; j++) {
            int cur = nums2[j];
            nums2_map.put(cur, nums2_map.getOrDefault(cur, 0) + 1);
            if (nums1_map.containsKey(cur)) {
                tmp.add(cur);
            }
        }

        for (int k = 0; k < nums3.length; k++) {
            int cur = nums3[k];
            if (nums1_map.containsKey(cur) || nums2_map.containsKey(cur)) {
                tmp.add(cur);
            }
        }

        for (Integer cur : tmp) {
            ans.add(cur);
        }
        return ans;
    }
}
