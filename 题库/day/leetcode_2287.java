package 题库.day;


/*

 */
public class leetcode_2287 {
    public static void main(String[] args) {
        leetcode_2287 leetcode_2287 = new leetcode_2287();
        String s = "abbaccaddaeea", target = "aa";
        int i = leetcode_2287.rearrangeCharacters(s, target);
        System.out.println(i);
    }

    public int rearrangeCharacters(String s, String target) {
        int ans = Integer.MAX_VALUE;
        // 统计target的词频
        int[] targetNum = new int[26];
        for (int i = 0; i < target.length(); i++) {
            int index = target.charAt(i) - 'a';
            targetNum[index]++;
        }

        int[] sNum = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            sNum[index]++;
        }

        for (int m = 0; m < 26; m++) {
            if (targetNum[m] != 0) {
                if (sNum[m] >= targetNum[m]) {
                    ans = Math.min(sNum[m] / targetNum[m], ans);
                } else {
                    ans = 0;
                }
            }
        }
        return ans;
    }


}
