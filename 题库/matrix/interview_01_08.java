package 题库.matrix;

import java.util.HashSet;
import java.util.Set;

/*
    题目：
        将某个地方的0 所在行和列全部置为0

 */
public class interview_01_08 {


    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> colZero = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }

        for (int rz : rowZero) {
            setRowZero(matrix, rz, col);
        }

        for (int cz : colZero) {
            setColZero(matrix, cz, row);
        }

    }

    public void setRowZero(int[][] matrix, int i, int n) {
        for (int k = 0; k < n; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = 0;
            }
        }
    }

    public void setColZero(int[][] matrix, int j, int m) {
        for (int k = 0; k < m; k++) {
            if (matrix[k][j] != 0) {
                matrix[k][j] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] v = new boolean[row][col];

        int[] rowZero = new int[row];
        int[] colZero = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (v[i][j]) {
                    continue;
                }
                // 所在列为0
                if (matrix[i][j] == 0 && !v[i][j]) {
                    if (rowZero[i] != 1) {
                        setRowZero(matrix, i, col, v);
                        rowZero[i] = 1;
                    }
                    if (colZero[j] != 1) {
                        setColZero(matrix, j, row, v);
                        colZero[j] = 1;
                    }
                    v[i][j] = true;
                }
            }
        }
    }


    public void setRowZero(int[][] matrix, int i, int n, boolean[][] v) {
        for (int k = 0; k < n; k++) {
            if (matrix[i][k] != 1 && !v[i][k]) {
                matrix[i][k] = 0;
                v[i][k] = true;
            }
        }
    }

    public void setColZero(int[][] matrix, int j, int m, boolean[][] v) {
        for (int k = 0; k < m; k++) {
            if (matrix[k][j] != 1 && !v[k][j]) {
                matrix[k][j] = 0;
                v[k][j] = true;
            }
        }
    }

}
