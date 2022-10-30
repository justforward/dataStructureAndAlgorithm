package leetcode.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_1773 {

    public static void main(String[] args) {
        System.out.println(1025&1024);
//        List<List<String>> iterms = new ArrayList<>();
//        iterms.add(Arrays.asList("ii", "iiiiiii", "ii"));
//        iterms.add(Arrays.asList("iiiiiii", "iiiiiii", "ii"));
//        iterms.add(Arrays.asList("ii", "iiiiiii", "iiiiiii"));
//
//        String ruleKey = "color";
//        String ruleValue = "ii";
//        leetcode_1773 leetcode_1773 = new leetcode_1773();
//        leetcode_1773.countMatches(iterms, ruleKey, ruleValue);
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        String type = "type";
        String color = "color";
        String name = "name";
        HashMap<String, List<String>> hashMap = new HashMap<>();
        hashMap.put(type, new ArrayList<>());
        hashMap.put(color, new ArrayList<>());
        hashMap.put(name, new ArrayList<>());
        for (List<String> list : items) {
            List<String> typeList = hashMap.get(type);
            typeList.add(list.get(0));
            hashMap.put(type, typeList);

            List<String> colorList = hashMap.get(color);
            colorList.add(list.get(1));
            hashMap.put(color, colorList);

            List<String> nameList = hashMap.get(name);
            nameList.add(list.get(2));
            hashMap.put(name, nameList);
        }

        int ans = 0;
        if (hashMap.containsKey(ruleKey)) {
            List<String> strings = hashMap.get(ruleKey);
            for (String s : strings) {
                if (s.equals(ruleValue)) ans++;
            }
        }
        return ans;
    }


}
