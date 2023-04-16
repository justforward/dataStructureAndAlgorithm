package 题库.hash;

import java.util.HashMap;
import java.util.Map;

public class interview_01_02 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bad";
        interview_01_02 i = new interview_01_02();
        System.out.println(i.CheckPermutation(s1, s2));
    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map1.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || map2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }

        return true;


        // 位远算
//        int bit = 0;
//        for (int i = 0; i < s1.length(); i++) {
//            bit ^= s1.charAt(i) - '0';
//        }
//
//        for (int j = 0; j < s2.length(); j++) {
//            bit ^= s2.charAt(j) - '0';
//        }
//        return bit == 0;
    }
}
