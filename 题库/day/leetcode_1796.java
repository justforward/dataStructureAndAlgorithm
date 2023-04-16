package 题库.day;

import java.util.TreeSet;

/*

 */
public class leetcode_1796 {
    public static void main(String[] args) {
        String s = "abc1111";
        leetcode_1796 leetcode_1769 = new leetcode_1796();
        System.out.println(leetcode_1769.secondHighest(s));

    }

    public int secondHighest(String s) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                tree.add(c - '0');
            }
        }
        if (tree.size() < 2) return -1;
        tree.pollLast();
        return tree.last();
    }
}
