package leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class A_base {
    public static void main(String[] args) {
        // 遍历
        HashMap<Character, Integer> map1 = new HashMap<>();
        // 插入
        map1.put('A', map1.getOrDefault('A', 0) + 1);

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
    }
}
