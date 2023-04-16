package 题库.offer.G字符串;

import java.util.HashMap;

/*
题目：

思路：
首先将order按顺序存储到HashMap或者数组中,再通过一一遍历words[i-1]与words[i]，在遍历时比较同一位下标的字符映射到HashMap或者数组中的顺序值，可得出
若words[i-1] < words[i] 且words[i] < words[i+1], 即words[i-1] < words[i] < words[i+1]
 */
public class offer_034 {
    public static void main(String[] args) {
        String[] words = new String[]{"kuvp", "q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        offer_034 offer_034 = new offer_034();
        System.out.println(offer_034.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        // 对比给定的字符 找到顺序 是否按照指定进行排序
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];

            int len = pre.length() > cur.length() ? pre.length() : cur.length();
            for (int j = 0; j < len; j++) {
                int index1 = j < pre.length() ? map.get(pre.charAt(j)) : -1;
                int index2 = j < cur.length() ? map.get(cur.charAt(j)) : -1;
                if (index1 < index2) break;
                if (index1 > index2) return false;
            }
        }
        return true;
    }
}
