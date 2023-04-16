package 题库.day;


public class leetcode_1832 {
    public boolean checkIfPangram(String sentence) {
        int[] dig = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            int cur = sentence.charAt(i) - 'a';
            dig[cur]++;
        }

        for (int i = 0; i < 26; i++) {
            if (dig[i] == 0) return false;
        }

        return true;
    }
}
