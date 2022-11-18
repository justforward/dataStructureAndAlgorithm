package leetcode.day;

import java.util.HashMap;

/**
 * @author tandi
 * @date 2022/11/13 10:04 上午
 */
public class leetcode_791 {
    public static void main(String[] args) {
        leetcode_791 leetcode_791 = new leetcode_791();
        String order = "cba", s = "abcd";
        leetcode_791.customSortString(order, s);
    }

    public String customSortString(String order, String s) {
        // 记录每个字母前一个位置的数据
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), 1);
        }

        HashMap<Character, Character> oMap = new HashMap<>();
        for (int i = 0; i < order.length() - 1; i++) {
            oMap.put(order.charAt(i), order.charAt(i + 1));
        }
        oMap.put(order.charAt(order.length() - 1), '0');

        StringBuilder stringBuilder = new StringBuilder();
        char end;
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            while (sMap.containsKey(cur) && oMap.containsKey(cur)) {
                if(oMap.get(cur)=='0'){

                }
                stringBuilder.append(cur);
                sMap.remove(cur);
                Character next = oMap.get(cur);
                cur = next;
            }
        }

        return stringBuilder.toString();
    }
}
