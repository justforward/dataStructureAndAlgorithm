package 题库.offer.P动态规划;

/**
 * @author tandi
 * @date 2023/3/14 下午10:00
 */
public class leetcode_5 {

    //longestPalindrome 最长回文子串
    public String longestPalindrome(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp[i][j]表示从i到j的字符串是否是回文串

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                // 单个单词 或者 aa这种
                if (j + 1 >= i - 1) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j + 1];
                }

                if (dp[i][j] && i - j + 1 > max) {
                    max = i - j + 1;
                    left = j;
                    right = i;
                }
            }
        }

        return s.substring(left, right + 1);
    }
}
