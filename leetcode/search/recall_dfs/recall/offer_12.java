package leetcode.search.recall_dfs.recall;


/*
    题目：在矩阵中找到一个单词，从矩阵中任意一点进行进行匹配，

    总结：
        1）机器人的移动是从规定的点，(0,0) 位置进行移动的
            矩阵中找到这个单词是从矩阵的任意一点都可以进行的

            所以需要枚举所有的值
        2）
 */

public class offer_12 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 可以从矩阵中任意一个点进行匹配
                if (dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, String word) {
        // 上 下 左 右都能移动的时候 需要判断 i j是否超过边界
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || !isValid(board, i, j, word.charAt(index)))
            return false;
        // 如果遍历到最后一个字母 进行返回
        if (index == word.length() - 1) return true;
        // 记录当前的ch
        char ch = board[i][j];
        //移动的时候，当前已经匹配的值进行标记操作？ 因为当前的值不能是重复使用？
        board[i][j] = '-';

        // 进入当前点的上下左右决策，这里是否会进行重复的值？
        // 遇到重复值的上下左右？ 是否会进行屏蔽掉？
        boolean res = dfs(board, i, j - 1, index + 1, word) ||
                dfs(board, i, j + 1, index + 1, word) ||
                dfs(board, i + 1, j, index + 1, word) ||
                dfs(board, i - 1, j, index + 1, word);
        board[i][j] = ch;
        return res;
    }

    public boolean isValid(char[][] board, int i, int j, char ch) {
        if (board[i][j] == ch) {
            return true;
        }
        return false;
    }
}
