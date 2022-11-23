package leetcode.offer.E回文;


/*
    题目：回文字符串的个数

    标签：动态规划

   回文串的判断：f[i][j] 是指的 i~j 的字符串是回文串，那么回文串的推导过程是：
   f[i][j]=f[i-1][j-1]&&s.charAt(i)==s.charAt(j)


    1) 中心扩展法

    2） 动态规划
    使用dp记录[0,....i] 中是否存在回文子串
 */
public class offer_020 {
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                // 先判断得到
                if (s.charAt(i) == s.charAt(j) && ((i - j) <= 1 || dp[i - 1][j + 1])) {
                    ans++;
                    dp[i][j] = true;
                }
            }
        }

        return ans;
    }
}
