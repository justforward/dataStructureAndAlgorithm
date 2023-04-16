package 题库.string;

import java.util.LinkedList;
import java.util.List;

/*
    思路： 1) hashMap？统计s1下标 和s2 的下标？
           2) 双指针
 */
public class leetcode_1790 {
    public static void main(String[] args) {
        String s1 = "abca", s2 = "abcc";
        leetcode_1790 leetcode_1790 = new leetcode_1790();
        System.out.println(leetcode_1790.areAlmostEqual(s1, s2));

    }

    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        if (len <= 2) {
            return s1.equals(s2);
        }

        int left = 0;
        int diff = 0;
        List<Character> list = new LinkedList<>();
        while (left < len) {
            if (s1.charAt(left) != s2.charAt(left)) {
                diff++;
                list.add(s1.charAt(left));
                list.add(s2.charAt(left));
            }
            if (diff > 2) {
                return false;
            }
            left++;
        }

        if (list.size() == 0) {
            return true;
        }
        if (list.size() == 4 && list.get(0) == list.get(3) && list.get(1) == list.get(2)) {
            return true;
        }
        return false;

    }
}


//        HashMap<Integer, Character> s1Map = new HashMap<>();
//        HashMap<Integer, Character> s2Map = new HashMap<>();
//        for (int i = 0; i < len; i++) {
//
//            s1Map.put(i, s1.charAt(i));
//            s2Map.put(i, s2.charAt(i));
//        }