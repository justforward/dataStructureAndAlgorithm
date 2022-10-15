package leetcode.weekend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author tandi
 * @date 2022/10/10 10:09 下午
 */
public class l_2423 {
    public static void main(String[] args) {
        String zz = "abbbccc";
        l_2423 l_2423 = new l_2423();
        System.out.println(l_2423.equalFrequency(zz));
    }


    public boolean equalFrequency(String word) {
        int[] fre = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            fre[index] += 1;
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
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
            if (map.size() == 1) {
                if (entry.getKey() == 1 || entry.getValue().size() == 1) {
                    return true;
                } else {
                    return false;
                }
            }
            key.add(entry.getKey());
            value.add(entry.getValue().size());
        }

        if (value.get(0) == 1 && value.get(1) == 1 &&
                (key.get(0) == 1 || key.get(1) == 1||Math.abs(key.get(0)-key.get(1))==1)) {
            return true;
        }

        if (value.get(0) == 1 || value.get(1) == 1) {
            if (value.get(0) == 1 && key.get(0) != 1) {
                return false;
            }
            if(value.get(0)==1&&key.get(0)==1){
                return true;
            }
            if (Math.abs(key.get(0) - key.get(1)) == 1) {
                return true;
            }
        }

        return false;


    }
}
