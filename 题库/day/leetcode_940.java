package 题库.day;

import java.util.HashSet;
import java.util.Set;

/*

    1、前缀树？

    位运算？

    2、统计字符串的个数 回溯？ 超时
    3、消除重复的值
    4、动态规划？
    对于子序列问题，通常可以从每个元素「选或不选」的角度入手。
    那如果把原问题细分一下，改为分别统计以 ‘a’,‘b’,⋯,‘z’ 结尾的不同子序列的个数，问题就迎刃而解了。

    状态转移方程：对于

 */
public class leetcode_940 {
    public static void main(String[] args) {
        String s = "aba";
        leetcode_940 leetcode_940 = new leetcode_940();
        System.out.println(leetcode_940.distinctSubseqII(s));
    }

    boolean[] v;
    Set<String> set = new HashSet<>();

    public int distinctSubseqII(String s) {
        char[] chars = s.toCharArray();
        v = new boolean[chars.length];
        TraceBack(chars, 0, new StringBuilder());
        set.stream().forEach(v->{
            System.out.println(v);
        });
        return set.size();
    }


    public void TraceBack(char[] chars, int index, StringBuilder stringBuilder) {
        if (index >= chars.length) {
            return;
        }
        for (int i = index; i < chars.length; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true;
            stringBuilder.append(chars[i]);
            set.add(stringBuilder.toString());
            TraceBack(chars, i + 1, stringBuilder);
            v[i] = false;
        }
    }

}
