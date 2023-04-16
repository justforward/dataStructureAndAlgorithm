package 题库.day;

import java.util.HashSet;
import java.util.Set;

/*
      请你用空格替换每个不是数字的字符。
      例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
      a123bc34d8ef34
 */
public class leetcode_1805 {
    public static void main(String[] args) {

        leetcode_1805 leetcode_1805 = new leetcode_1805();
        String s = "0000a000";
        System.out.println(leetcode_1805.numDifferentIntegers(s));
    }


    public int solution2(String word) {
        Set<String> set = new HashSet<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            // 找到数字的开头
            if (word.charAt(i) <= '9') {
                // j 从i开始
                int j = i;
                while (j < len && word.charAt(j) <= '9') j++;
                while (i < j && word.charAt(i) == '0') i++;
                // 截取需要放入到set的string 长度
                set.add(word.substring(i, j));
                // 当前的点直接跳到j的位置
                i = j;
            }
        }
        return set.size();
    }

    public int numDifferentIntegers(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (cur <= 'z' && cur >= 'a') {
                stringBuilder.append(" ");
            } else {
                stringBuilder.append(cur);
            }
        }
        String[] split = stringBuilder.toString().trim().split("\\s+");
        if (split.length == 1 && split[0].equals("")) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String s : split) {
            // 如果s前面有0值
            StringBuilder stringBuilder1 = new StringBuilder();
            boolean f = true;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0') {
                    stringBuilder1.append(s.charAt(i));
                    f = false;
                    continue;
                }
                if (s.charAt(i) == '0' && f) {
                    continue;
                }
                if (s.charAt(i) == '0' && !f) {
                    stringBuilder1.append(s.charAt(i));
                }

            }
            set.add(stringBuilder1.toString());
        }
        return set.size();
    }
}
