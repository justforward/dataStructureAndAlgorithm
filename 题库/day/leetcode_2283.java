package 题库.day;

import java.util.HashMap;
import java.util.Map;

public class leetcode_2283 {
    public static void main(String[] args) {
        leetcode_2283 leetcode_2283 = new leetcode_2283();
        System.out.println(leetcode_2283.digitCount("030"));
    }

    public boolean digitCount(String num) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int cur = c - '0';
            hashMap.put(cur, hashMap.getOrDefault(cur, 0) + 1);
        }

        for (int j = 0; j < num.length(); j++) {
            // 当前的值 等于0的时候
            int cur = num.charAt(j) - '0';
            if (cur == 0 && !hashMap.containsKey(j)) {
                continue;
            }
            if (!hashMap.containsKey(j)) {
                return false;
            }
            if (hashMap.get(j) != cur) {
                return false;
            }
        }
        return true;
    }
}
