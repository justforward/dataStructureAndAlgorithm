package 题库.array;

import java.util.*;

public class test {
    public static void main(String[] args) {
        test test = new test();
        int[] skill = new int[]{3, 2, 5, 1, 3, 4};
        System.out.println(test.dividePlayers(skill));
    }

    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        // 第一个和最后一个
        String f = strs[0];
        String l = strs[strs.length - 1];
        if (f.charAt(0) != l.charAt(l.length() - 1)) return false;
        char pre = f.charAt(f.length() - 1);
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            char c = cur.charAt(0);
//            System.out.println(pre);
//            System.out.println(c);
            if (pre != c) return false;
            pre = cur.charAt(cur.length() - 1);
        }
        return true;
    }

    public long dividePlayers(int[] skill) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = skill.length;
        int ave = len / 2;
        int sum = 0;
        for (int s : skill) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
            sum += s;
        }
        if (sum % ave != 0) return -1;
        int pre = sum / ave;

        long ans = 0;
        for (int s : skill) {
            int sub = pre - s;
            if (!hashMap.containsKey(sub) || hashMap.get(sub) == 0) return -1;
            hashMap.put(sub, hashMap.get(sub) - 1);
            ans += s * sub;
        }
        return ans / 2;
    }

    // 链接的点 之间的差距在-1内
//    public int magnificentSets(int n, int[][] edges) {
//
//
//    }

}
