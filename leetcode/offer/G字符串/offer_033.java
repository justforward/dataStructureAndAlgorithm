package leetcode.offer.G字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    字符排序
 */
public class offer_033 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] tmpRes = str.toCharArray();
            Arrays.sort(tmpRes);
            String key = String.valueOf(tmpRes);
            if (hashMap.containsKey(key)) {
                List<String> list = hashMap.get(key);
                list.add(str);
                hashMap.put(key, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
            }

        }

        return new ArrayList<List<String>>(hashMap.values());
    }
}
