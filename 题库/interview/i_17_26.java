package 题库.interview;

import java.util.*;

/*
    题目：只记录关联度相同的文档，可以假定每个文档由一个含有不同整数的数组表示。不同的数组之前才会出现相同的数字
    标签：倒排索引
    思路：
        1）直接暴力求解？超时
        2）倒排索引：思维转变一下，不是把两个数组比较，看有没有重复的。
           2.1）每次的数字出现，都去检查一下是否出现过，在哪个数组里出现的。
                hashMap 其中key就是遍历到的数字，value就是数字曾经出现的下标
           2.2）用一个help矩阵来存储n行数组与m行数组之间有多少交集

            2.3）  String.format("%.4f", tmp)  构建的数字包含小数点后4位，不够的位补全
                    注意：tmp必须是double

 */
public class i_17_26 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{14, 15, 100, 9, 3}, {32, 1, 9, 3, 5}, {15, 29, 2, 6, 8, 7}, {7, 10}};
        i_17_26 i = new i_17_26();
        i.computeSimilarities(nums);
    }

    public List<String> computeSimilarities(int[][] docs) {
        List<String> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        // n*n 行
        int[][] help = new int[docs.length][docs.length];
        for (int i = 0; i < docs.length; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                List<Integer> list = map.get(docs[i][j]);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(docs[i][j], list);
                } else {
                    // 已经存在这个数，查看哪个
                    for (Integer k : list) {
                        //记录这个数 在哪行出现
                        help[i][k]++;
                    }
                }
                // 记录这个数的行
                list.add(i);
            }

            // 得到这个length长度
            for (int k = 0; k < docs.length; k++) {
                if (help[i][k] > 0) {
                    // 得到i和k所在行的宽度，- 重复的数字
                    double tmp = (double) help[i][k] / (docs[i].length + docs[k].length - help[i][k]);
                    ans.add(k + "," + i + ": " +
                            // 构建的数字包含小数点后4位，不够的位补全
                            String.format("%.4f", tmp));
                }
            }
        }
        return ans;

    }

    // 暴力—— 超时
    public List<String> computeSimilarities1(int[][] docs) {
        List<String> res = new ArrayList<>();
        // 遍历docs 得到相关的数据
        int row = docs.length;
        for (int i = 0; i < row; i++) {
            Set<Integer> set = new HashSet<>();
            int i_col = docs[i].length;
            for (int k = 0; k < i_col; k++) {
                set.add(docs[i][k]);
            }
            for (int j = i + 1; j < row; j++) {
                // 位运算
                Set<Integer> sum = new HashSet<>();
                sum.addAll(set);
                int j_col = docs[j].length;
                for (int m = 0; m < j_col; m++) {
                    sum.add(docs[j][m]);
                }

                // 根据长度进行判断
                if (sum.size() == i_col + j_col) {
                    // 没有相似度，直接找下一行
                    continue;
                } else {
                    int sub = i_col + j_col - sum.size();
                    int total = sum.size();
                    StringBuilder s = new StringBuilder();
                    String format = String.format("%.4f", (double) sub / total);
                    // "0,1: 0.2500"
                    s.append(i).append(",").append(j).append(": ").append(format);
                    res.add(s.toString());
                }
            }
        }
        return res;
    }
}
