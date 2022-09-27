package leetcode.bit.weekend;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangtan
 * @date 2022/9/27 10:52 下午
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
            Set<Integer> cur2 = new HashSet();
            for (int y : cur){
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }
}
