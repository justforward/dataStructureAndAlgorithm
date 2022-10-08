package leetcode.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tandi
 * @date 2022/10/8 10:43 下午
 * 查看得到的数是否是偶数 一个奇数即可
 */
public class i_01_04 {

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean haveOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (haveOdd) {
                    return false;
                } else {
                    haveOdd = true;
                }
            }
        }
        return true;
    }
}
