package leetcode.day;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class leetcode_2299 {
    public static void main(String[] args) {
        leetcode_2299 l = new leetcode_2299();
        String password = "Me+You--IsMyDream";
        System.out.println(l.strongPasswordCheckerII(password));
    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        String s = "!@#$%^&*()-+";
        int num = 0, bigWord = 0, smallWord = 0, special = 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < password.length(); i++) {
            char cur = password.charAt(i);
            List<Integer> list = new LinkedList<>();
            if (map.containsKey(cur)) {
                list = map.get(cur);
                if (i - list.get(list.size() - 1) == 1) {
                    return false;
                }
            }
            list.add(i);
            map.put(cur, list);

            if (Character.isDigit(cur)) {
                num++;
                continue;
            }

            if (Character.isLowerCase(cur)) {
                smallWord++;
                continue;
            }
            if (Character.isUpperCase(cur)) {
                bigWord++;
                continue;
            }

            if (s.contains(String.valueOf(cur))) {
                special++;
            }
        }


        return num != 0 && bigWord != 0 && smallWord != 0 && special != 0;

    }
}
