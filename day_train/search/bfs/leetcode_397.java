package day_train.search.bfs;

/*
    题目：
        给定一个正整数 n ，你可以做如下操作：
        1、如果 n 是偶数，则用 n / 2替换 n 。
        2、如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
        返回 n 变为 1 所需的 最小替换次数 。

    思路：每个奇数都需要进行+1 或者-1 的操作
    按照每个点进行搜索 找到可能存在的值？得到最小的值
    dfs 搜索

    int -> long
    int nums=0;
    nums*1L

 */

import java.util.HashMap;

public class leetcode_397 {
    HashMap<Long, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        return dfs(n * 1L, 0);
    }

    public int dfs(Long n, int count) {
        if (n == 1) {
            map.put(n, count);
            return count;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = 0;
        count++;
        if (n % 2 == 0) {
            ans = dfs(n / 2, count);
        } else {
            int count1 = dfs(n - 1, count);
            int count2 = dfs(n + 1, count);
            ans = Math.min(count1, count2);
        }
        return ans;

    }

    public static void main(String[] args) {
        leetcode_397 leetcode_397 = new leetcode_397();
        System.out.println((1*1.0)/2);
    }

}
