package 题库.offer.D滑动窗口;

import java.util.HashMap;

/*
    包含所有字符的子串的最短

    给定两个字符串 s 和t 。返回 s 中包含t的所有字符的最短子字符串。
    如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
    如果 s 中存在多个符合条件的子字符串，返回任意一个。
 */
public class offer_017 {

    public static void main(String[] args) {
        offer_017 offer_017 = new offer_017();
        String s = "ADOBECODEBAC", t = "ABC";
        System.out.println(offer_017.minWindow(s, t));
    }


    public String minWin(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> winMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, start = 0, end = 0, len = Integer.MAX_VALUE, valid = 0;

        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;

            // 只有需要这个当前的数据时候 才会加入到winMap中
            if (needMap.containsKey(cur)) {
                winMap.put(cur, winMap.getOrDefault(cur, 0) + 1);
                if (needMap.get(cur) == winMap.get(cur)) {
                    valid++;
                }
            }

            // 开始缩减窗口
            while (valid == needMap.size()) {

                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }

                char rm = s.charAt(left);
                left++;
                if (needMap.containsKey(rm)) {
                    if (needMap.get(rm) == winMap.get(rm)) {
                        valid--;
                    }
                    // 从winMap中-- 数据
                    winMap.put(rm, winMap.get(rm) - 1);
                }

            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);

    }


    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> winMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            needMap.put(t.charAt(i), needMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int valid = 0;
        int l = s.length();
        int right = 0, left = 0, start = 0, end = 0, len = Integer.MAX_VALUE;
        while (right < l) {
            char c = s.charAt(right);
            right++;

            if (needMap.containsKey(c)) {
                winMap.put(c, winMap.getOrDefault(c, 0) + 1);
                if (winMap.get(c).equals(needMap.get(c))) {
                    valid++;
                }
            }

            while (valid == needMap.size()) {
                // 已经满足条件，记录起始位置和长度
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }

                // 开始 left++ ,将d移除窗口
                char d = s.charAt(left);
                left++;

                if (needMap.containsKey(d)) {
                    if (winMap.get(d).equals(needMap.get(d))) {
                        valid--;
                    }
                    winMap.put(d, winMap.get(d) - 1);
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

}