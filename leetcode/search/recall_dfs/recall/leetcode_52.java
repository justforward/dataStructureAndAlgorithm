package leetcode.search.recall_dfs.recall;

import java.util.Arrays;

/*
    题目：n个皇后进行放入到n*n的棋盘上
       要求：
        1）同行 同列都不能出现 Q
        2）斜对角不能出现相同的皇后

    思路：回溯进行构建
 */
public class leetcode_52 {

    public static void main(String[] args) {
        leetcode_52 l = new leetcode_52();
        System.out.println(l.totalNQueens(1));
    }

    //var res [][]string
    Integer res = 0;

    public int totalNQueens(int n) {
        //二维数组的初始化
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        //从第一个开始遍历
        dfs(board, n, 0);
        return res;
    }

    public void dfs(char[][] board, int n, int row) {
        //所有的行都运行完毕
        if (n == row) {
            res++;
            return;
        }

        //遍历数组
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col, n)) {
                continue;
            }
            board[row][col] = 'Q';
            //指向下一行
            dfs(board, n, row + 1);
            board[row][col] = '.';
        }

    }


    //判断是否合法
    public boolean isValid(char[][] board, int row, int col, int n) {
        //判断同行
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //判断同列
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }


        //判断对角线 左上角是否有冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //判断对角线，右上角是否冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
