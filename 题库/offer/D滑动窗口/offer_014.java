package 题库.offer.D滑动窗口;


/*
    查看s2的子串是否包含s1中的全部字母

    滑动窗口
 */
public class offer_014 {
    public static void main(String[] args) {
        offer_014 offer_014 = new offer_014();
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(offer_014.checkInclusion(s1, s2));
        // 每个单词下的长度 往后数 10^8 次幂 还是能得到
    }

    // s1 need s2
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        int[] win = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need[c - 'a']++;
        }

        int left = 0, right = 0, valid = 0;

        while (right < s2.length()) {
            char m = s2.charAt(right);
            right++;

            if (need[m - 'a'] > 0) {
                win[m - 'a']++;
                if (win[m - 'a'] == need[m - 'a']) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                // need len=valid
                if (valid == getLen(need)) {
                    return true;
                }

                char c = s2.charAt(left);
                left++;
                // 从left出去的数据
                if (win[c - 'a'] > 0) {
                    // 如果当前值满足条件
                    if (win[c - 'a'] == need[c - 'a']) {
                        valid--;
                    }
                    win[c - 'a']--;
                }
            }

        }
        return false;
    }

    public int getLen(int[] need) {
        int ans = 0;
        for (int i = 0; i < need.length; i++) {
            if (need[i] > 0) {
                ans++;
            }
        }
        return ans;
    }

}
