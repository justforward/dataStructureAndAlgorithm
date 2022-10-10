package leetcode.interview;


/*
    题目：
        1）对一个N*N矩阵进行翻转90度
            1.1）首先将该矩阵按照轴对角线进行翻转
            1.2）然后将每一行的值进行反转

        相关题目：给你一个包含若干单词和空格的字符串 s，请你写一个算法，原地反转所有单词的顺序
                解题思路：先将整个字符串 s 反转，然后分别将每个单词再进行反转
 */
public class i_01_07 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        i_01_07 i = new i_01_07();
        i.rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        int N = matrix.length;
        //1、首先按照对角线进行翻转 每次就遍历二维矩阵的其中一半
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //2、将每一行的值进行反转
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while (left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }

    }
}
