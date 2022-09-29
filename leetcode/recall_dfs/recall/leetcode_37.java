package leetcode.recall_dfs.recall;

/*
    将给出的数字填充到9*9的键盘上
    如何判断填充值的有效性
 */
public class leetcode_37 {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    public boolean backTrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            return backTrack(board, i + 1, 0);
        }
        if (i == m) {
            return true;
        }

        // 存在预设的值，直接进行返回
        if (board[i][j] != '.') {
            return backTrack(board, i, j + 1);
        }

        for (char k = '1'; k <= '9'; k++) {

            if (!isValid(board, i, j, k)) {
                continue;
            }
            board[i][j] = k;

            // 针对有返回值的 需要进行处理操作
            if (backTrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }

        return false;
    }

    public boolean isValid(char[][] board, int i, int j, char ch) {
        for (int m = 0; m < 9; m++) {
            if (board[i][m] == ch) return false;
            if (board[m][j] == ch) return false;
            // 遍历3*3的小括号
            if (board[i / 3 * 3 + m / 3][j / 3 * 3 + m % 3] == ch) return false;
        }
        return true;
    }
}
