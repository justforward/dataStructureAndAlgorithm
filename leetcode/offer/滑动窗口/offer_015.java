package leetcode.offer.滑动窗口;

import java.util.ArrayList;
import java.util.List;


/*
    滑动窗口
 */
public class offer_015 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        offer_015 offer_15 = new offer_015();
        offer_15.findAnagrams(s, p);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] win = new int[26];
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need[c - 'a'] > 0) {
                win[c - 'a']++;
                if (win[c - 'a'] == need[c - 'a']) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == getPLen(need)) {
                    list.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 出去一个值
                if (need[d - 'a'] > 0) {
                    if (win[d - 'a'] == need[d - 'a']) {
                        valid--;
                    }
                    win[d - 'a']--;
                }
            }
        }
        return list;

    }

    public int getPLen(int[] need) {
        int ans = 0;
        for (int i : need) {
            if (i > 0) {
                ans++;
            }
        }
        return ans;
    }
}
