package 题库.day;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    字典树：前缀树

    如何记录字母的相对位置？是否存在重复的字母
    1）哈希表去记录数组中字母的位置 然后根据words里面的数组找到位置进行排序？

 */
public class leetcode_792 {
    public static void main(String[] args) {
        String s = "abcde";
        String[] words = new String[]{"a", "bb", "acd", "ace"};
        leetcode_792 leetcode_792 = new leetcode_792();
    }

    // 解法一：暴力求解
    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            if (isSub(word, s)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isSub(String s, String t) {
        int k = 0;
        for (int i = 0; i < t.length() && k < s.length(); i++) {
            if (s.charAt(k) == t.charAt(i)) {
                k++;
            }
        }
        return k == s.length();
    }

    // 解法二：预处理 hash 二分
    public int numMatchingSubseq1(String s, String[] words) {
        int ans = 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        for (String word : words) {
            // 得到遍历的数字
            boolean ok = true;
            int m = word.length();
            int idx = -1;
            for (int i = 0; i < m && ok; i++) {
                List<Integer> list = map.getOrDefault(word.charAt(i), new ArrayList<>());
                int l = 0, r = list.size() - 1;
                // 一直遍历得到满足大于前面idx位的最小值
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (list.get(mid) > idx) r = mid;
                    else l = mid + 1;
                }

                // 如果r的值不存在，或者得到的r小于等于idx 那么直接不匹配 进行返回即可
                if (r < 0 || list.get(r) <= idx) ok = false;
                // 否则选择当前的值 作为idx的下标
                else idx = list.get(r);
            }
            if (ok) ans++;
        }

        return ans;
    }
}
