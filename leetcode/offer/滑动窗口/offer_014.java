package leetcode.offer;


import java.util.Arrays;
import java.util.HashMap;

/*
    查看s2的子串是否包含s1中的全部字母

    滑动窗口
 */
public class offer_014 {
    public static void main(String[] args) {
        offer_014 offer_014 = new offer_014();
        String s1 = "hello", s2 = "ooolleoooleh";
        System.out.println(offer_014.checkInclusion(s1, s2));
        // 每个单词下的长度 往后数 10^8 次幂 还是能得到
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        // 从当前这个位置进行
        for(int i = 0;i < s1.length();i++){
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(a,b)){
            return true;
        }
        int left = 0,right = s1.length();
        while(right < s2.length()){
            b[s2.charAt(right) - 'a']++;
            b[s2.charAt(left) - 'a']--;
            if(Arrays.equals(a,b)){
                return true;
            }
            right++;
            left++;
        }
        return false;
    }
}
