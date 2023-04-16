package 题库.search.recall_dfs.recall;

/*
    题目： 在矩阵中填充数字
            1）数字 1-9 在每一行只能出现一次。
            2）数字 1-9 在每一列只能出现一次。
            3）数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

            输入的数据：对于 . 是默认的空白格

    思路: 遍历每个点，找到这个点所在的行、列、3*3 小矩阵是否满足条件
          1）行
          2）列
          3）3*3 小矩阵  如何确定某个数落在哪个小方块中？
          小方块的编号和行、列的关系
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        leetcode_36 l = new leetcode_36();
        System.out.println(l.isValidSudoku(board));

    }

    public boolean isValidSudoku(char[][] board) {
        // 记录某行 某列下的所有
        Map<Integer, Set<Integer>> row = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int cur = board[i][j] - '0';
                // 判断这个indx 所在的位置在这个3*3的表格中
                int indx = i / 3 * 3 + j / 3;
                // 直接查看当前的某个数是否跟之前出现了冲突即可
                if (row.get(i).contains(cur) || col.get(j).contains(cur) || area.get(indx).contains(cur)) return false;
                row.get(i).add(cur);
                col.get(j).add(cur);
                // 这个是3*3的数组进行统计
                area.get(indx).add(cur);
            }
        }
        return true;

    }
}
