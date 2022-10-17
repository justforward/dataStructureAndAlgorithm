package leetcode.day;

import java.util.HashMap;

/*
    连续的最大值？
     滑动窗口？滑动窗口的条件？如果当前的值连续出现的频率大于前一个数，那么直接替换这个数

     题目解析：
        间隔为1|0的连续最大值

     每次遍历找到 出现间隔为0|1的连续最大值 就直接替换当前的结果？
 */
public class leetcode_904 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        leetcode_904 leetcode_904 = new leetcode_904();
        System.out.println(leetcode_904.totalFruit(nums));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length < 2) {
            return fruits.length;
        }
        // 在fruits的数组长度大于2的时候，保底是2个？
        int ans = Integer.MIN_VALUE;
        int tmp = 0;

        // 不能存储当前的，只能存储每次滑动窗口的map
        HashMap<Integer, Integer> map = new HashMap<>();
        // 记录当前最大的频率 从1 开始

        int n = fruits.length;
        int left = 0, right = 0;
        while (right < n) {
            int cur = fruits[right];

            if (!map.containsKey(cur) && map.size() >= 2) {
                ans = Math.max(tmp, ans);
                while (map.size() >= 2) {
                    // 长度超过2 排除left指向的数 在map的大小
                    int deleteValue = fruits[left];
                    if (map.get(deleteValue) == 1) {
                        map.remove(deleteValue);
                    } else {
                        map.put(deleteValue, map.get(deleteValue) - 1);
                    }
                    tmp--;
                    left++;
                }
            }

            map.put(cur, map.getOrDefault(cur, 0) + 1);
            tmp++;
            right++;
        }

        return Math.max(ans, tmp);
    }
}
