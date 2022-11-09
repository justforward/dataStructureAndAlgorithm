package leetcode.day;

public class leetcode_1684 {
    public static void main(String[] args) {
        leetcode_1684 leetcode_1684 = new leetcode_1684();
        String allowed = "abc";
        String[] words = new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(leetcode_1684.countConsistentStrings(allowed, words));
    }

    // 找到是否有相同的位 是否出现全部的位都能进行抵消？
    public int countConsistentStrings(String allowed, String[] words) {

        int ans = 0;
        int allBit = 0;
        for (int i = 0; i < allowed.length(); i++) {
            allBit |= 1 << (allowed.charAt(i) - 'a');
        }

        int[] wordBit = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < words[i].length(); j++) {
                // 为什么要左移动一位？
                wordBit[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        for (int i = 0; i < wordBit.length; i++) {
            if ((wordBit[i] | allBit) == allBit) ans++;
        }

        return ans;

    }
}
