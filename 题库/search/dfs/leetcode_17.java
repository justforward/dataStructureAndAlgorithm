package 题库.search.dfs;

import java.util.ArrayList;
import java.util.List;

/*
    每个数字代表的字母
    字母的排列组合？

    1) 直接搜索的方式
    2）回溯 进行
 */
public class leetcode_17 {
    public static void main(String[] args) {
        System.out.println('2' - '2');
    }
    // 每次key代表的字符
    public List<String> letterCombinations_sol1(String digits) {
        // 直接搜索，
        String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            List<String> now = new ArrayList<>();
            String digit = strings[digits.charAt(i) - '2'];
            for (int j = 0; j < digit.length(); j++) {
                for (int m = 0; m < res.size(); m++) {
                    now.add(res.get(m) + digit.charAt(j));
                }
            }
            res = now;
        }
        return res;
    }


    List<String> res = new ArrayList<>();
    String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations_sol2(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backed(0, digits, new StringBuilder());
        return res;
    }

    public void backed(int start, String digits, StringBuilder stringBuilder) {
        //一直走到最后一个
        if (start == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }

        // 每一个节点都需要往下一个节点找
        for (int j = start; j < digits.length(); j++) {
            String index = strings[digits.charAt(j) - '2'];
            for (int m = 0; m < index.length(); m++) {
                stringBuilder.append(index.charAt(m));
                backed(j + 1, digits, stringBuilder);
                stringBuilder.deleteCharAt(m);
            }
        }

    }


}
