package leetcode.recall;

/*
    题目： 在矩阵中填充数字
            1）数字 1-9 在每一行只能出现一次。
            2）数字 1-9 在每一列只能出现一次。
            3）数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

            输入的数据：对于 . 是默认的空白格

    思路：回溯 遍历数组判断是否满足条件
 */

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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;

    }

    /*public boolean back(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            return back(board, i + 1, 0);
        }

        if (i == m) {
            return true;
        }

        if (board[i][j] == '.') {
            return backTracked()
        }

        // 检查当前值是否满足要求
        if (!isValid(board, i, j, board[i][j])) {

        }

    }*/


    public boolean backTracked(char[][] board, int i, int j) {
        int m = 9, n = 9;
        // 穷举到最后一列，就要进行下一行
        if (j == n) {
            return backTracked(board, i + 1, 0);
        }

        // 遍历到最后一行
        if (i == m) {
            return true;
        }

        // 一开始的预设数字
        if (board[i][j] != '.') {
            return backTracked(board, i, j + 1);
        }

        // 对i行的当前每一个数进行枚举
        for (char ch = '1'; ch <= '9'; ch++) {
            // 做选择
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            backTracked(board, i, j + 1);
            board[i][j] = '.';
        }

        // 穷举完所有的1~9 都没有找到一个可行解
        return false;
    }

    // 判断是否可以存入当前的 c值
    public boolean isValid(char[][] board, int i, int j, char c) {
        for (int m = 0; m < 9; m++) {
            // i 所在行 排除当前的位置
            if (j != m && board[i][m] == c) return false;
            // j 所在列
            if (i != m && board[m][j] == c) return false;

            // 判断 3 x 3 方框是否存在重复
            if (board[(i / 3) * 3 + m / 3][(j / 3) * 3 + m % 3] == c)
                return false;
        }
        return true;
    }
}
