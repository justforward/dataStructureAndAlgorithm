package 题库.day;

/*
    序列dp
 */
public class leetcode_1668 {
    public static void main(String[] args) {
        leetcode_1668 leetcode_1668 = new leetcode_1668();
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
        System.out.println(leetcode_1668.maxRepeating(sequence, word));
    }

    public int maxRepeating(String sequence, String word) {
        // dp 定义f(i) 是以i为结尾的最大重复子串
        int ans = 0;
        int m = sequence.length(), n = word.length();
        int[] f = new int[m + 10];
        // i 从1 开始到m结束 边界的确定？
        for (int i = 1; i <= m; i++) {
            // 往前截取字符的长度
            if (i - n < 0) continue;
            if (sequence.subSequence(i - n, i).equals(word)) f[i] = f[i - n] + 1;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
