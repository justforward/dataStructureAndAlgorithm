package leetcode.weekend;

import java.util.*;

public class leetcode_2423 {
    public static void main(String[] args) {
        String s = "abbcc";
        leetcode_2423 leetcode_2423 = new leetcode_2423();
        System.out.println(leetcode_2423.equalFrequency(s));
    }

    public boolean equalFrequency(String word) {
        int[] fre = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            fre[index] += 1;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j = 0; j < fre.length; j++) {
            int num = fre[j];
            if (num == 0) {
                continue;
            }
            List<Integer> list = null;
            if (map.containsKey(num)) {
                list = map.get(num);
            } else {
                list = new ArrayList<>();
            }
            list.add(j);
            map.put(num, list);
        }


        if (map.size() > 2) {
            return false;
        }

        List<Integer> key = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (map.size() == 1 && entry.getKey() == 1) {
                return true;
            }
            key.add(entry.getKey());
            value.add(entry.getValue().size());
        }

        if (value.get(0) == 1 || value.get(1) == 1) {
            if (Math.abs(key.get(0) - key.get(1)) == 1) {
                return true;
            }
        }

        return false;

    }
}
