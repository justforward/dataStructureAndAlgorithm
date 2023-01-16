package leetcode.day;


/*
    双指针：

 */
public class leetcode_1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        // 根据切分的数组判断 words1 存储的是最长的数组
        if (words1.length < words2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int m = words1.length, n = words2.length;
        int i = 0, j = 0;
        while (i < n && words1[i].equals(words2[i])) {
            i++;
        }

        while (j < n && words1[m - 1 - j].equals(words2[n - 1 - j])) {
            j++;
        }

        return i + j >= n;
    }
}
