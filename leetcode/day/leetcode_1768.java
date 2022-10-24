package leetcode.day;

public class leetcode_1768 {
    public static void main(String[] args) {
        String word1 = "abcd", word2 = "pq";
        leetcode_1768 leetcode_1768 = new leetcode_1768();
        System.out.println(leetcode_1768.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int len = m > n ? n : m;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(word1.charAt(i)).append(word2.charAt(i));
        }

        for (int k = len; k < m; k++) {
            stringBuilder.append(word1.charAt(k));
        }

        for (int t = len; t < n; t++) {
            stringBuilder.append(word2.charAt(t));
        }

        return stringBuilder.toString();
    }
}
