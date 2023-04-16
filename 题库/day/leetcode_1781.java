package 题库.day;


/*
        用两个下标i和j表示子字符串的两段，用双层循环来遍历所有子字符串，第一层遍历子字符串的起点i，
        第二层循环固定i，遍历子字符串的终点j，遍历时候维护更新用来记录字符频率的hash表

        如何维护？频率的最大值和最小值？
        1）最大值，在记录的过程中，进行统计
        2）最小值，在计算完成后统计？

     */
public class leetcode_1781 {

    public static void main(String[] args) {
        String s = "aabcbaa";
        leetcode_1781 leetcode_1781 = new leetcode_1781();
        System.out.println(leetcode_1781.beautySum(s));
    }

    // 直接进行统计
    public int beautySum(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            //int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                //maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = Integer.MAX_VALUE;
                int maxFreq = Integer.MIN_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                        maxFreq = Math.max(maxFreq, cnt[k]);
                    }
                }
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }
}
