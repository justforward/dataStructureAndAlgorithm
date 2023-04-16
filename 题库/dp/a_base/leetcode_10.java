package 题库.dp.a_base;

/*

     dp(s,i,p,j) = true   说明s[i..]和p[j..] 可以匹配 否则是不能匹配

       答案是dp(s,0,p,0) 的结果

 */

public class leetcode_10 {
    public boolean isMatch(String s, String p) {
        //从 0 0位置开始匹配
       return dp(s, 0, p, 0);
    }


    public boolean dp(String s, int i, String p, int j) {
        // base case
        int len_s = s.length();
        int len_p = p.length();

        if (j == len_p) {
            return i == len_s;
        }

        if (i == len_s) {
            // 如果能匹配空字符串，一定是字符和*成对出现
            if ((len_p - j) % 2 == 1) {
                return false;
            }

            // 匹配 a*b*的情况 下一个是*的情况
            for (; j + 1 < len_p; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 考虑*
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                // 如果下一个是* 那么可以匹配0次和1次
                // 匹配0次的时候，需要将j+2 选择之后的一个数进行匹配
                return dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                // 否则继续走到下一个 常规的匹配
                return dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                return dp(s, i, p, j + 2);
            } else {
                // 否则直接不能匹配
                return false;
            }
        }

    }
}
