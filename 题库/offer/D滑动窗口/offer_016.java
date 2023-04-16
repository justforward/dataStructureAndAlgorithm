package 题库.offer.D滑动窗口;

import java.util.*;

/*
    win里面判断是否重复？
    重复的值就需要t出去
 */
public class offer_016 {
    public static void main(String[] args) {
        String s = "aab";
        offer_016 offer_016 = new offer_016();
        System.out.println(offer_016.lengthOfLongestSubstring(s));
    }

    /*
        s 由英文字母、数字、符号和空格组成
        包含了非字母 不能使用int[26] 数组进行处理
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        if (s.length() == 1) return 1;
        Set<Character> list = new LinkedHashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (list.contains(c)) {
                ans = Math.max(ans, right - left);
                //需要将left移除
                while (left < right) {
                    Character m = s.charAt(left);
                    left++;
                    list.remove(m);
                    if (m == c) {
                        break;
                    }
                }
            }
            list.add(c);
            right++;
        }

        return ans < list.size() ? list.size() : ans;
    }

    public int resolve1(String s) {
        int ans = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length() && left < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
                ans = Math.max(ans, right - left);
            }
        }

        return ans;
    }
}
