package leetcode.search.recall_dfs.recall;

import java.util.ArrayList;
import java.util.List;

/*
    思路：直接选
 */

public class o_2_079 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        o_2_079 o = new o_2_079();
        o.subsets(nums);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> stack = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backed(nums, 0);
        return res;
    }

    public void backed(int[] nums, int index) {
        // 每个遍历到这里的值都可以存放到结果集中
        // 每次需要将这个元素从新构建一个才放入res中
        ArrayList<Integer> tmp = new ArrayList<>(stack);
        res.add(tmp);
        //每天
        for (int i = index; i < nums.length; i++) {
            // 一直往里面添加数据
            stack.add(nums[i]);
            backed(nums, i + 1);
            // 删除添加的最后一个元素
            stack.remove(stack.size() - 1);
        }
    }


}
