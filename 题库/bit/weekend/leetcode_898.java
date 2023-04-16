package 题库.bit.weekend;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtan
 * @date 2022/9/27 10:52 下午
 * 思路：
 * 使用一个集合cur存储以j为结尾的result值
 * 这个result的值一直是递增的。| 的结果是单调递增的
 */
public class leetcode_898 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4};
        leetcode_898 l = new leetcode_898();
        int i = l.subarrayBitwiseORs(nums);
        System.out.println(i);
    }

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x : arr) {
            // 针对每个数，先记录以j为结尾的result值，下一个值跟cur中的每个值进行异或得到当前子数组中的值。一直进行
            Set<Integer> cur2 = new HashSet();
            for (int y : cur) {
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }


    public int subBit(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        // 0|A=A 确定一开始的值就是遍历第一个结果的本身
        cur.add(0);
        for (int x : arr) {
            Set<Integer> cur2 = new HashSet<>();
            for (int c : cur) {
                int tmp = x | c;
                cur2.add(tmp);
            }
            // 将本次遍历的值也要添加到cur2中?
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();

    }
}
