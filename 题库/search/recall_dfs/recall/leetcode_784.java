package 题库.search.recall_dfs.recall;

import java.util.ArrayList;
import java.util.List;

public class leetcode_784 {
    List<String> ans;
    private char[] chars;


    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();

        this.chars = s.toCharArray();
        bfs(0);
        return ans;
    }


    public void bfs(int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }

        // 选择
        if (Character.isLetter(chars[index])) {
            chars[index] ^= 1 << 5;
            bfs(index + 1);
            chars[index] ^= 1 << 5;
        }

        // 不选
        bfs(index + 1);

    }

    public static void main(String[] args) {
        leetcode_784 leetcode_784 = new leetcode_784();
        String ss = "a1b2";
        leetcode_784.letterCasePermutation(ss);
        System.out.println((char) ('b' & '_'));

    }
}
